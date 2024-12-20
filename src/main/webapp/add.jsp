<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRK</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	<div class="container">
		<h1 class="text-center my-5">Welcome to Employee Management</h1>

		<div class="w-75 mx-auto">
			<form action="employee" method="post">
				<div class="mb-3">
					<label for="name" class="form-label">Name</label> <input
						type="text" class="form-control" id="name" name="name" required>
				</div>

				<div class="mb-3">
					<label for="gender" class="form-label">Gender</label><br>
					<div>
						<input type="radio" id="male" name="gender" value="Male" required>
						<label for="male">Male</label>
					</div>
					<div>
						<input type="radio" id="female" name="gender" value="Female"
							required> <label for="female">Female</label>
					</div>
					<div>
						<input type="radio" id="other" name="gender" value="Other"
							required> <label for="other">Other</label>
					</div>
				</div>

				<div class="mb-3">
					<label for="salary" class="form-label">Salary</label> <input
						type="number" class="form-control" id="salary" name="salary"
						required>
				</div>

				<div class="mb-3">
					<label for="joiningDate" class="form-label">Date of Joining</label>
					<input type="date" class="form-control" id="joiningDate"
						name="joiningDate" required>
				</div>

				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">Email
						Address</label> <input type="email" class="form-control"
						id="exampleInputEmail1" name="email" required>
					<div id="emailHelp" class="form-text">We'll never share your
						email with anyone else.</div>
				</div>


				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</div>
</body>
</html>