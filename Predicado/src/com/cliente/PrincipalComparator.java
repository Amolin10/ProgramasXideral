package com.cliente;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import com.interfaces.PredicadoEmpleado;
import com.pojo.Empleado;

public class PrincipalComparator {

	public static void main(String[] args) {

		List<Empleado> listaEmpleados = new ArrayList<>();
		listaEmpleados.add(new Empleado("Patrobas",28,45.67));
		listaEmpleados.add(new Empleado("Tercio",15,56.67));
		listaEmpleados.add(new Empleado("Andronico",19,40.50));
		listaEmpleados.add(new Empleado("Rolas",17,60.03));
		
		/*
		 * Creamos un comparador de empleados, 
		 * regresa un negativo si el de la izquierda va primero
		 * regresa un positivo si el de la izquierda va después
		 * Regresa 0 si son iguales
		 */
		Comparator<Empleado> comparadorNombre = (a, b) -> a.getNombre().compareTo(b.getNombre());

		Comparator<Empleado> comparadorEdad = (a, b) -> a.getEdad() - b.getEdad();
		
		Comparator<Empleado> comparadorSueldo = (a, b) -> (int) (b.getSueldo() - a.getSueldo());
		
		/*
		 * Utilizando el predicado de Java
		 */
		Predicate<Empleado> nombre = a ->  a.getNombre().endsWith("o");
		System.out.println(nombre.test(new Empleado("Andronico",19,40.50)));
		
		/*
		 * Utilizando el predicado de Java con dos parámetros
		 */
		BiPredicate<Empleado, Empleado> edad = (a, b) ->  a.getEdad() > b.getEdad();
		System.out.println(edad.test(new Empleado("Andronico",19,40.50), new Empleado("Rolas",17,60.03)));
		
		/*
		 * Ordenar por nombre
		 * Le pasamos el comparador
		 */
		//Collections.sort(listaEmpleados, comparadorNombre);
		//Collections.sort(listaEmpleados, comparadorEdad);
		Collections.sort(listaEmpleados, comparadorSueldo);
	
		/*
		 * Imprimimos la lista
		 * a cada empleado e
		 * le aplicamos System.out.println(e)
		 */
		listaEmpleados.forEach(e -> System.out.println(e));
		
	}
}
