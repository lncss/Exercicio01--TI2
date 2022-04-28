  package com.ti2cc;

import static spark.Spark.*;

public class HelloWorld {
	public static void main(String[] args) {
		port(4570);
		get("/hello",(request, response)-> "Hello World");
	}
}
