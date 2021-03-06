select title, mean_vote, genre, duration, country, language, director, production_company, actors, description, avg_vote, votes
from IMDb_movies inner join IMDb_ratings
	on (IMDb_movies.imdb_title_id = IMDb_ratings.imdb_title_id)
order by avg_vote desc;