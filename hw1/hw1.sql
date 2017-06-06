--James Quach
--Elizabeth O'Neil
--CS436
--9/19/2016

--CS636 Homework 1 Review, Setup, and Intro to JDBC
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
--2. Review SQL. Read Murach pp. 364-373. 
================================================================================
--Select from nobel:  4, 7 

--1-4.Give the name of the 'Peace' winners since the year 2000, including 2000

SELECT winner peace_winner
	FROM nobel
		WHERE subject = 'Peace'
			AND yr >= 2000
			
--				Peace_winner
--Martti Ahtisaari
--Intergovernmental Panel on Climate Change
--Al Gore
--Grameen Bank
--Muhammad Yunus
--International Atomic Energy Agency
--Mohamed ElBaradei
--Wangari Maathai
--Shirin Ebadi
--Jimmy Carter
--United Nations
--Kofi Annan
--Kim Dae-jung

-1-7. Show the winners with first name John

SELECT winner
FROM nobel
WHERE winner 
LIKE 'John%'

--               winner
--John C. Mather
--John L. Hall
--John B. Fenn
--John E. Sulston
--John Pople
--John Hume
--John E. Walker
--John C. Harsanyi
--John F. Nash Jr.
--John C. Polanyi
--John R. Vane
--John H. van Vleck
--John Cornforth
--John R. Hicks
--John Bardeen
--John C. Kendrew
--John Steinbeck
--John Bardeen
--John F. Enders
--John Cockcroft
--John H. Northrop
--John R. Mott
--John Galsworthy
--John Macleod
--------------------------------------------------------------------------------
--Select within select:  2, 4. 6 

--2-2.Show the countries in Europe with a per capita GDP greater than 'United 
--Kingdom'.

SELECT a.name Country
	FROM world a
	WHERE a.continent = 'Europe'
	AND a.gdp/a.population >
	(
	SELECT b.gdp/b.population
	FROM world b
	WHERE b.name = 'United Kingdom'
	)

--					Country
--Andorra
--Austria
--Belgium
--Denmark
--Finland
--France
--Germany
--Iceland
--Ireland
--Liechtenstein
--Luxembourg
--Monaco
--Netherlands
--Norway
--San Marino
--Sweden
--Switzerland

--2-4.Which country has a population that is more than Canada but less than 
--Poland? Show the name and the population.

SELECT a.name country, a.population
FROM world a
WHERE a.population >
(
  SELECT b.population
  FROM world b
  WHERE b.name = 'Canada'
)
AND a.population <
(
  SELECT c.population
  FROM world c
  WHERE c.name = 'Poland'
)

--country	population
--Iraq	36004552
--Sudan	37289406

--2-6.Which countries have a GDP greater than every country in Europe? [Give 
--the name only.] (Some countries may have NULL gdp values)

SELECT name Country
	FROM world 
	WHERE gdp > ALL(
		SELECT gdp 
		FROM world 
			WHERE continent = 'Europe' 
			AND gdp IS NOT null)

-- 			Country
--Japan
--United States
--------------------------------------------------------------------------------
--Sum and count: 2, 4, 6 

--3-2.List all the continents - just once each.

SELECT DISTINCT Continent
	FROM world

--	Continent
--Africa
--Asia
--Caribbean
--Eurasia
--Europe
--North America
--Oceania
--South America

--3-4.How many countries have an area of at least 1000000

SELECT COUNT(name) Country
	FROM world
	WHERE area >= 1000000

--	Country
--28

--3-6. For each continent show the continent and number of countries.

SELECT continent, COUNT(name) Countries
	FROM world
	GROUP BY continent

--	Continent	Countries
--Africa	53
--Asia	46
--Caribbean	11
--Eurasia	2
--Europe	43
--North America	11
--Oceania	14
--South America	13
--------------------------------------------------------------------------------
--More Joins: 3, 6, 7, 9

--4-3.List all of the Star Trek movies, include the id, title and yr (all of 
--these movies include the words Star Trek in the title). 
--Order results by year

SELECT id, title, yr
	FROM  movie
	WHERE title 
		LIKE '%Star Trek%'
		ORDER BY yr

--	id				title				yr
--17772	Star Trek: The Motion Picture	1979
--17775	Star Trek II: The Wrath of Khan	1982
--17776	Star Trek III: The Search for Spock	1984
--17777	Star Trek IV: The Voyage Home	1986
--17779	Star Trek V: The Final Frontier	1989
--17780	Star Trek VI: The Undiscovered Country	1991
--17774	Star Trek Generations	1994
--17770	Star Trek: First Contact	1996
--17771	Star Trek: Insurrection	1998
--17778	Star Trek Nemesis	2002
--17773	Star Trek	2009

--4-6. What is the id of the film 'Casablanca'

SELECT id
FROM movie
WHERE title = 'Casablanca'

--	id
--11768

--4-7. Obtain the cast list for 'Casablanca'.  what is a cast list? Use 
--movieid=11768, this is the value that 
--you obtained in the previous question.

SELECT name Name
	FROM actor
	JOIN casting 
		ON actor.id = casting.actorid
		WHERE casting.movieid = 11768
		
--	Name
--Peter Lorre
--John Qualen
--Madeleine LeBeau
--Jack Benny
--Dan Seymour
--Norma Varden
--Ingrid Bergman
--Conrad Veidt
--Leon Belasco
--Humphrey Bogart
--Sydney Greenstreet
--Helmut Dantine
--Leonid Kinskey
--Wolfgang Zilzer
--Claude Rains
--Curt Bois
--Leo White
--Ludwig StÃ¶ssel
--Marcel Dalio
--Paul Henreid
--Joy Page
--S. Z. Sakall
--Dooley Wilson
--William Edmunds
--Gregory Gaye
--Torben Meyer
--Georges Renavent
--Jean Del Val
--Louis V. Arco
--Trude Berliner
--Ilka GrÃ¼nig
--Richard Ryen
--Hans Twardowski

--4-9. List the films in which 'Harrison Ford' has appeared

SELECT movie.title Movies
	FROM movie
	JOIN casting 
		ON movie.id = casting.movieid
		JOIN actor 
			ON actor.id = casting.actorid
			WHERE name = 'Harrison Ford'

--			Movies
--A Hundred and One Nights
--Air Force One
--American Graffiti
--Apocalypse Now
--Clear and Present Danger
--Cowboys & Aliens
--Crossing Over
--Dead Heat on a Merry-Go-Round
--Extraordinary Measures
--Firewall
--Force 10 From Navarone
--Hanover Street
--Hawthorne of the U.S.A.
-- Hollywood Homicide
-- Indiana Jones and the Kingdom of the Crystal Skull
-- Indiana Jones and the Last Crusade
-- Indiana Jones and the Temple of Doom
-- Jimmy Hollywood
-- K-19: The Widowmaker
-- More American Graffiti
-- Morning Glory
-- Patriot Games
-- Presumed Innocent
-- Raiders of the Lost Ark
-- Random Hearts
-- Regarding Henry
-- Sabrina
-- Sally of the Sawdust
-- Shadows
-- Six Days Seven Nights
-- Smilin' Through
-- Star Wars Episode IV: A New Hope
-- Star Wars Episode V: The Empire Strikes Back
-- Star Wars Episode VI: Return of the Jedi
-- The Conversation
-- The Devil's Own
-- The Fugitive
-- The Mosquito Coast
-- The Star Wars Holiday Special
-- What Lies Beneath
-- Witness
-- Working Girl
			
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------