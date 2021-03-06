import sqlite3
import pandas as pd
from tensorflow.keras import layers, Model

con = sqlite3.connect('IMDB.db')
cur = con.cursor()
df = pd.read_sql_query("""select title, mean_vote, genre, duration, country, language, director, production_company, actors, description, avg_vote, votes
from IMDb_movies inner join IMDb_ratings
	on (IMDb_movies.imdb_title_id = IMDb_ratings.imdb_title_id)
order by avg_vote desc;""", con)

print(df.to_numpy())