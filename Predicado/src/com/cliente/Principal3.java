package com.cliente;

import java.util.*;

import com.interfaces.*;
import com.pojo.Empleado;

public class Principal3 {

	public static void main(String[] args) {

		List<Empleado> listaEmpleados = new ArrayList<>();
		listaEmpleados.add(new Empleado("Patrobas",28,45.67));
		listaEmpleados.add(new Empleado("Tercio",15,56.67));
		listaEmpleados.add(new Empleado("Andronico",19,40.50));
		listaEmpleados.add(new Empleado("Rolas",17,60.03));
		
		PredicadoEmpleado pe = e -> (e.getSueldo() > 45 && e.getNombre().length() > 6);
		
		System.out.println("Empleados cuyo nombre es mayor a 6 y ganan más de 45");
		ejecuta(listaEmpleados, pe);
	}
	
	private static void ejecuta(List<Empleado> listaEmpleados, 
			PredicadoEmpleado pe ) {	
		for (Empleado e:listaEmpleados) 
			if (pe.probar(e))
				System.out.println(e);
	}

}
