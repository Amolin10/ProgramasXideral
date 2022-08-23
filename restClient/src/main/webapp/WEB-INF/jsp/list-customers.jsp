<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<title>List Customers</title>
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2 class="h2">CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Add Customer"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="btn btn-dark btn-lg"
			/>
		
			<!--  add our html table here -->
		
			<table class="table table-striped">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
				</thead>

				<tbody>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>					
					

						<tr>
							<td> ${tempCustomer.nombre} </td>
							<td> ${tempCustomer.apellido} </td>
							<td> ${tempCustomer.deporte} </td>
							
							<td>
								<!-- display the update link -->
								<a class="btn btn-primary btn-sm" href="${updateLink}">Update</a>
								|
								<a class="btn btn-primary btn-sm" href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
							</td>
							
						</tr>
						
					</c:forEach>
					
				</tbody>
					
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









