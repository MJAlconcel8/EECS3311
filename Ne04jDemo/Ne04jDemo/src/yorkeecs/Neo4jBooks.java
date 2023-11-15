package yorkeecs;
import static org.neo4j.driver.v1.Values.parameters;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Config;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.Transaction;

public class Neo4jBooks {
	
	private Driver driver;
	private String uriDb;
	
	public Neo4jBooks() {
		uriDb = "bolt://localhost:7687"; // may need to change if you used a different port for your DBMS
		Config config = Config.builder().withoutEncryption().build();
		driver = GraphDatabase.driver(uriDb, AuthTokens.basic("neo4j","1234"), config);
	}
	
	public void insertAuthor(String author) {
		try (Session session = driver.session()){
			session.writeTransaction(tx -> tx.run("MERGE (a:Author {author: $x})", 
					parameters("x", author)));
			session.close();
		}
	}
	
	public void insertTitle(String title) {
		try (Session session = driver.session()){
			session.writeTransaction(tx -> tx.run("MERGE (a:Title {title: $x})", 
					parameters("x", title)));
			session.close();
		}
	}
	
	public void insertBook(String author, String title) {
		try (Session session = driver.session()){
			session.writeTransaction(tx -> tx.run("MATCH (a:Author {author:$x}),"
					+ "(t:Title {title:$y})\n" + 
					 "MERGE (a)-[r:WROTE]->(t)\n" + 
					 "RETURN r", parameters("x", author, "y", title)));
			session.close();
		}
	}
	
	public void printBook(String author, String title)
    {
        try (Session session = driver.session())
        {
        	try (Transaction tx = session.beginTransaction()) {
        		StatementResult node_boolean = tx.run("RETURN EXISTS( (:Author {author: $x})"
        				+ "-[:WROTE]-(:Title {title: $y}) ) as bool"
						,parameters("x", author, "y", title) );
        		if (node_boolean.hasNext()) {
        			System.out.println(author + " wrote " + title);
        		}
        	}
        }
    }
	
	public void close() {
		driver.close();
	}
}

