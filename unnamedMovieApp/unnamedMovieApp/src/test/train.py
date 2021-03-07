import sqlite3
import pandas as pd
import numpy as np
from sklearn.metrics.pairwise import cosine_similarity
from sklearn.feature_extraction.text import CountVectorizer


def query_database():
	con = sqlite3.connect('../IMDb.db')
	cur = con.cursor()
	df = pd.read_sql_query("""select Poster_Link, Series_Title, Released_Year, Certificate, Runtime, Genre, IMDB_Rating, Overview, Director, Star1, Star2, Star3
							from imdb_top_1000
							where Certificate is not NULL
							and IMDB_Rating > 5
							order by IMDB_Rating desc;""", con)
	return df

def create_tokens(row):
	vector = CountVectorizer().fit_transform(row).toarray()
	#print(vector.shape)
	return vector

def vectorize_data(df):
	#print(df.keys().tolist())
	data = {}
	data.update({"Poster_Link":df["Poster_Link"]})
	data.update({"Series_Title":df["Series_Title"]})
	data.update({"Released_Year":df["Released_Year"]})
	data.update({"Certificate":create_tokens(df["Certificate"])})
	data.update({"Runtime":create_tokens(df["Runtime"])})
	data.update({"Genre":create_tokens([i.replace(',', '') for i in df["Genre"].tolist()])})
	data.update({"IMDB_Rating":df["IMDB_Rating"]})
	data.update({"Overview":create_tokens(df["Overview"])})
	data.update({"Director":create_tokens(df["Director"])})
	data.update({"Star1":create_tokens(df["Star1"])})
	data.update({"Star2":create_tokens(df["Star2"])})
	data.update({"Star3":create_tokens(df["Star3"])})
	#data.update({"votes": df["votes"]})
	#print(data)
	return data

def calculate_score(rated_movies, data, i):
	movie_names = rated_movies.keys()
	movie_indicies = []
	#max_year = np.max(data["Released_Year"])
	#max_runtime = np.max(data["Released_Year"])
	for movie in movie_names:
		movie_indicies.append(np.where(data["Series_Title"] == movie))
	x = np.zeros(len(data.keys())-1)
	for j, movie in enumerate(movie_names):
		if movie in data["Series_Title"].tolist():
			#x[0] += 1 - np.abs(data["Release_Year"][movie_indicies[j]]/max_year - data["Release_Year"][i]/max_year)
			x[1] += cosine_similarity(data["Certificate"][movie_indicies[j]].reshape(1,-1), data["Certificate"][i].reshape(1,-1))[0][0] * (-1 if rated_movies[movie] == 0 else 1)
			#x[2] += 1 - abs(data["Runtime"][movie_indicies[j]]/max_runtime - data["Runtime"][i]/max_runtime)
			x[3] += 3 * cosine_similarity(data["Genre"][movie_indicies[j]].reshape(1,-1), data["Genre"][i].reshape(1,-1))[0][0] * (-1 if rated_movies[movie] == 0 else 1)
			x[4] += (data["IMDB_Rating"][i] / 10)  * (-1 if rated_movies[movie] == 0 else 1)
			x[5] += 2 * cosine_similarity(data["Overview"][movie_indicies[j]].reshape(1,-1), data["Overview"][i].reshape(1,-1))[0][0] * (-1 if rated_movies[movie] == 0 else 1)
			x[6] += cosine_similarity(data["Director"][movie_indicies[j]].reshape(1,-1), data["Director"][i].reshape(1,-1))[0][0] * (-1 if rated_movies[movie] == 0 else 1)
			x[7] += cosine_similarity(data["Star1"][movie_indicies[j]].reshape(1,-1), data["Star1"][i].reshape(1,-1))[0][0] * (-1 if rated_movies[movie] == 0 else 1)
			x[8] += cosine_similarity(data["Star2"][movie_indicies[j]].reshape(1,-1), data["Star2"][i].reshape(1,-1))[0][0] * (-1 if rated_movies[movie] == 0 else 1)
			x[9] += cosine_similarity(data["Star3"][movie_indicies[j]].reshape(1,-1), data["Star3"][i].reshape(1,-1))[0][0] * (-1 if rated_movies[movie] == 0 else 1)
	return np.sum(x)

def get_recomendations(user, data):
	name = user["name"]
	rated_movies = user["rated_movies"]
	scores = np.zeros(len(data["Series_Title"]))
	for i in range(len(scores)):
		scores[i] = calculate_score(rated_movies, data, i)
	#print(scores)

	top_idx = np.argsort(scores)
	http_paths, best_movies, best_ratings, certificates = data["Poster_Link"][top_idx][::-1].tolist(), \
											data["Series_Title"][top_idx][::-1].tolist(), \
											data["IMDB_Rating"][top_idx][::-1].tolist(), \
											data["Certificate"][top_idx][::-1].tolist()
	for movie in rated_movies.keys():
		if movie in best_movies:
			index = best_movies.index(movie)
			best_movies.pop(index)
			best_ratings.pop(index)
	best_movies = best_movies[:20]
	best_ratings = best_ratings[:20]
	
	print()
	for i in (range(len(best_movies))):
		print(best_movies[i], best_ratings[i])
	output = []
	for i in (range(len(best_movies))):
		output.append(best_movies[i])
<<<<<<< HEAD:train.py
=======
	return output
>>>>>>> 2a97c6600b9e9d6ef8f903e4db898a869fd22c6f:unnamedMovieApp/unnamedMovieApp/src/test/train.py


df = query_database()
user1 = {"name": "sam", "rated_movies": {"The Matrix":1, "Alien":1, "The Shining":1}}
user2 = {"name": "colin", "rated_movies": {"The Lord of the Rings: The Return of the King":1, "Titanic":0}}
data = vectorize_data(df)

output = get_recomendations(user2, data)
print(output)