-- src/main/resources/data-movie-pictures.sql
-- Drop the MOVIE_PICTURE table if it exists
DROP TABLE IF EXISTS movie_picture;

-- Create the MOVIE_PICTURE table
CREATE TABLE IF NOT EXISTS movie_picture (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    GENRE VARCHAR(255) NOT NULL,
    URL VARCHAR(255) NOT NULL,
    FAVORITES_COUNT INT NOT NULL,
    RELEASE_YEAR INT NOT NULL
    );

-- Insert initial data
-- Insert additional movies
INSERT INTO movie_picture (name, url, favorites_count, release_year, genre) VALUES
                                                                                ('The Shawshank Redemption', 'https://example.com/shawshank_redemption.jpg', 100, 1994, 'Drama'),
                                                                                ('The Godfather', 'https://example.com/godfather.jpg', 95, 1972, 'Crime'),
                                                                                ('The Dark Knight', 'https://example.com/dark_knight.jpg', 92, 2008, 'Action'),
                                                                                ('12 Angry Men', 'https://example.com/12_angry_men.jpg', 87, 1957, 'Drama'),
                                                                                ('Schindler''s List', 'https://example.com/schindlers_list.jpg', 86, 1993, 'Biography'),
                                                                                ('The Lord of the Rings: The Return of the King', 'https://example.com/return_of_the_king.jpg', 85, 2003, 'Adventure'),
                                                                                ('Pulp Fiction', 'https://example.com/pulp_fiction.jpg', 83, 1994, 'Crime'),
                                                                                ('The Lord of the Rings: The Fellowship of the Ring', 'https://example.com/fellowship_of_the_ring.jpg', 80, 2001, 'Adventure'),
                                                                                ('Forrest Gump', 'https://example.com/forrest_gump.jpg', 79, 1994, 'Drama'),
                                                                                ('The Good, the Bad and the Ugly', 'https://example.com/good_bad_ugly.jpg', 78, 1966, 'Western'),
                                                                                ('The Lord of the Rings: The Two Towers', 'https://example.com/two_towers.jpg', 77, 2002, 'Adventure'),
                                                                                ('The Matrix', 'https://example.com/matrix.jpg', 76, 1999, 'Action'),
                                                                                ('Goodfellas', 'https://example.com/goodfellas.jpg', 75, 1990, 'Biography'),
                                                                                ('Seven Samurai', 'https://example.com/seven_samurai.jpg', 74, 1954, 'Drama'),
                                                                                ('Interstellar', 'https://example.com/interstellar.jpg', 73, 2014, 'Adventure'),
                                                                                ('City of God', 'https://example.com/city_of_god.jpg', 72, 2002, 'Crime'),
                                                                                ('Se7en', 'https://example.com/se7en.jpg', 71, 1995, 'Crime'),
                                                                                ('The Silence of the Lambs', 'https://example.com/silence_of_the_lambs.jpg', 70, 1991, 'Crime'),
                                                                                ('Saving Private Ryan', 'https://example.com/saving_private_ryan.jpg', 69, 1998, 'Drama'),
                                                                                ('The Green Mile', 'https://example.com/green_mile.jpg', 68, 1999, 'Crime'),
                                                                                ('The Usual Suspects', 'https://example.com/usual_suspects.jpg', 67, 1995, 'Crime'),
                                                                                ('Léon: The Professional', 'https://example.com/leon.jpg', 66, 1994, 'Action'),
                                                                                ('American History X', 'https://example.com/american_history_x.jpg', 65, 1998, 'Drama'),
                                                                                ('The Lion King', 'https://example.com/lion_king.jpg', 64, 1994, 'Animation'),
                                                                                ('Gladiator', 'https://example.com/gladiator.jpg', 63, 2000, 'Action'),
                                                                                ('Back to the Future', 'https://example.com/back_to_the_future.jpg', 62, 1985, 'Adventure'),
                                                                                ('The Departed', 'https://example.com/departed.jpg', 61, 2006, 'Crime'),
                                                                                ('The Prestige', 'https://example.com/prestige.jpg', 60, 2006, 'Drama'),
                                                                                ('The Pianist', 'https://example.com/pianist.jpg', 59, 2002, 'Biography');

