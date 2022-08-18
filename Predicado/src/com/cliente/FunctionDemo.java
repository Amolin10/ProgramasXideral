package com.cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

import com.pojo.Empleado;

public class FunctionDemo {

	public static void main(String[] args) {
		
		Function<Empleado, String> f0 = e -> e.getNombre();
		String nombreEmpleado = f0.apply(new Empleado("Andronico",19,40.50));
		System.out.println(nombreEmpleado);
		
		Function <List<Empleado>, Empleado> f1 = ls -> ls.get(0);
        
		List<Empleado> listaEmpleados = new ArrayList<>();
		listaEmpleados.add(new Empleado("Patrobas",28,45.67));
		listaEmpleados.add(new Empleado("Tercio",15,56.67));
		listaEmpleados.add(new Empleado("Andronico",19,40.50));
		listaEmpleados.add(new Empleado("Rolas",17,60.03));
		
		Empleado emp = f1.apply(listaEmpleados);
		System.out.println(emp);
		
		Function<String, Integer> strLen = s -> s.length();
		int tam = strLen.apply("Hola");
		System.out.println(tam);
		
		UnaryOperator<String> bo = s -> s.concat("World");
		System.out.println(bo.apply("Hello "));
		
	}
}
