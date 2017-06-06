/*
James Quach
Elizabeth O'Neil
CS436
9/19/2016
================================================================================
3. Review Java OO principles, specifically the idea that all Java classes are 
subclasses of the Object class, and thus must have all the methods of the 
Object class. You can see the Object class API (and any other standard class) 
by following the link on the class web page under Resources Java (4th line 
down under Resources). Choose “Object” in the pane titled All Classes, and 
the API will be displayed on the right.
================================================================================

*/
import java.util.*;
import java.lang.*;
import java.io.*;
/*
a. What are the three most important Object methods?  (Hint: their names 
start with e, h, and t). Because all objects have these methods, we can use 
HashSet to contain any set of objects (we'll stick to sets of same-type 
objects in our work).

The three most important methods are 
hashCode() method: Returns a hash value that is be used to search object in a 
collection 

equals() method: Gives generic way to compare objects.


toString() method: Can be used to convert the object to String


https://en.wikibooks.org/wiki/Java_Programming/API/java.lang.Object
*/

/*

b. Show equals in use by writing one if (…) that checks whether s String s is 
equal to a String t, character by character.  Explain what this comparison is 
doing if s = “abc” and t = “abx”.  Compare this to what happens in if (s == t).
*/
String s = new String("abc");
String t = new String("abx");
if (s.equals(t)){
	return true;
}
else{
	System.out.println("Strings Not Equals ");
	return false;
}
/*
The equals function in this case actually checks the actual contents of the 
string. Like actually comparing the individual contents of the string.

In if(s==t){.....}, the '==' operator checks whether the references to the
object are equal.
*/

/*
c.  Find the hashCode and toString values for String s = “abc”.  Also for the 
Integer of value 6.
*/
int i = 6;
class valueFinder
{
	public static void main (String[] args) throws java.lang.Exception
	{
		String s = new String("abc");
		int i = 6;
		System.out.println("hashCode " + s.hashCode() + " and " + "toString  " 
		+ s.toString()); 
		//96354 and abc
		System.out.println("hashCode " + 'i' + " and " 
		+ "toString  " + 'i'); 
		// 6   and   6

}}

/*
d. Write a small Java class Box1.java that has private int fields x, y for 
the dimensions of the (2-dimensional) box in mm. Give it getters and setters 
for x and y, and a simple constructor that takes x and y values, but no other 
methods. This is a simple “Java Bean”.  For Box1 objects b and c, separately 
created but both describing 10x12 boxes, what is b.equals(c)? What is being 
compared here?

*/

public class Box1 {
	int x = 10;
	int y = 12;
	public Box1(x , y){
		public void setX(int x){
			this.x=x;
		}
		public void setY(int y){
			this.y=y;
		}
		public int getX(){
			return x;
		}
		public int getY(){
			return y;
		}
	}
}
Box1 b = new Box1();
Box1 c = new Box1();

b.equals(c); 
//the x and y values are respectively being compared to each other

/*

e. For Java class Box2.java, start from the Box1.java code and add an equals 
method that compares the x’s and y’s of the two Box2 objects to see if they 
are both the same or not.  Make sure your equals method overrides 
Object.equals by using the annotation @Override (it’s easy to go wrong here). 
For an example, see 
http://www.geeksforgeeks.org/overriding-equals-method-in-java/.Write a 
hashCode method that is consistent with your equals method.  Consistent here 
means satisfying the second bulleted requirement under the Object.hashCode 
documentation, namely “If two objects are equal according to the 
equals(Object) method, then calling the hashCode method on each of the two 
objects must produce the same integer result.” Finally, write a toString 
method that returns “10x12” for a 10 by 12 box.  For Box2 objects b and c, 
separately created but both describing 10x12 boxes, what is b.equals(c)?
*/
public class Box2 {
	int x = 10;
	int y = 12;
	public Box2(x , y){
		public void setX(int x){
			this.x=x;
		}
		public void setY(int y){
			this.y=y;
		}
		public int getX(){
			return x;
		}
		public int getY(){
			return y;
		}
	}
}
Box2 b = new Box2();
Box2 c = new Box2();

b.equals(c) @Override;
System.out.println(b.toString());
System.out.println(c.toString());
System.out.println(b.hashCode());
System.out.println(b.hashCode());



/*

4. Review Java Collection classes.  Look at the Collection Framework home 
page at Oracle, and from there the Collections Framework Overview and 
Collections Tutorial, for Java 8.  . 

a.  What are the two most important concrete classes that are available for 
the Set interface?  the Map interface? 

For the Set interface:
java.util.HashSet<E>
java.util.TreeSet<E>

For the Map interface:
java.util.HashMap<K, V>
java.util.TreeMap<K, V>

b.  Explain how you can find all the elements of a given Set object.  Does 
your answer also apply to Lists?  other things?  what class of objects? 

	I would find all the elements of a given Set object would be to use the 
iterator() method. For List I would use the get() method.


c.  Explain how you can find all the keys of a given Map.

I would use the keySet() method to return a set with all the keys of a
Map.


d.  Write a Java fragment that creates a Map from String to Integer. Add the 
association "x" -> 1, that is, key "x" maps to Integer 1. 

*/

import java.util.HashMap;
import java.util.Map

public class StringToInt{
	private Map<String, Integer> map;
	private int count = Integer.c;
	public StringToInt(){
		map new HashMap<String, Integer>();
	}
	public int toInt(String s){
		Integer i = map.get(s);
		if(i==null){
			map.put(s,c);
			i=c;
			++c;
		}
		return i;
	}
}


/*
5.  Start learning (or review) JDBC. Read Murach, Chap. 12 through pg. 387, 
and the Oracle tutorial on basic JDBC, specifically the sections named 
“Setting Up Tables” and “Retrieving and Modifying Values from Result Sets”, 
mainly the first example.


a. What Java classes (include package name) support JDBC and are used in the 
Oracle tutorial section “Setting Up Tables”?  For each, briefly explain what 
it provides. Note that con is assumed to be an available field of type 
Connection. 

driver="${DB.DRIVER}": this provides the drivers for the database.

url="${DB.URL}": connection url for DBMS JDBC driver uses to connect to
a database.
    
userid="${DB.USER}": name of valid user in DBMS.

password="${DB.PASSWORD}": password of specified userid
    
classpathref="CLASSPATH": full path name of jar file that contains the 
class in driver
    
delimiter="${DB.DELIMITER}": string/char that seperates sql statements


b. Do you need a new Connection for each SQL statement?  Explain.
 
	Yes because con is used to provide a new connection to a database 
by creating a statement object.

c.  Find the JDBC API documentation among the usual JSE Javadocs at 
http://docs.oracle.com/javase/8/docs/api/.  In particular, read 
Connection.close() and explain what it means.  The "resources" here involve 
the TCP/IP connection to the database, an OS resource not directly managed 
the the Java vitual machine (JVM.) 

	The close() method here explicitly disconnects immediatly from the 
Connection object's database and JDBC resources instead of waiting to be 
automatically released.

d.  Explain how to use the "getXXX" methods.  What getXXX methods would you 
normally use with a VARCHAR(100) column?  a FLOAT column?  a DECIMAL(7,2) 
column? a TIMESTAMP column? Explain what these SQL datatypes mean. For 
detailed info on JDBC and SQL datatypes, see  
http://docs.oracle.com/javase/6/docs/technotes/guides/jdbc/getstart/mapping.htm
l#996857. 

For VARCHAR(100), I would use a getString() method according to 8.3.1. For a 
FLOAT Column, I would use a getFloat() method according to 8.4.3. For DECIMAL 
column, I would use a getBigDecimal() method according to 8.3.11. For TIMESTAMP 
I would use a getTimestamp() method according to 8.6.6. 

VARCHAR(100) represents a small variable length of character strings (up to 
100 characters). FLOAT is a floating point number that is similiar to the 
Java's Double. DECIMAL represents fixed precsion decimal values, DECIMAL(7,2) 
miht be represented by numbers larger than 7 digits. TIMESTAMP represents 
DATA and TIME plus a nanosecond field.  

*/


/*
6b. Mysql

jquach93@topcat:~$ mysql -u ronghui -D ronghuidb -p
Enter password: ronghui
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 695
Server version: 5.6.31-0ubuntu0.14.04.2 (Ubuntu)

Copyright (c) 2000, 2016, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql>


*/



/*
7. DevelopmentSetup Progress
Notepad++ checks
Eclipse checks
JDK checks

*/