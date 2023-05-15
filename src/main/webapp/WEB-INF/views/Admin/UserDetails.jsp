<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Details</title>
    <link rel = "stylesheet" href = "<%= request.getContextPath() %>/css/booking.css" />
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="<%= request.getContextPath() %>/js/Room.js" type="text/javascript"></script>
</head>

<body>

<div style = "margin-left: 30px; margin-right: 30px;">
    <nav class="bg-gray-800">
        <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
            <div class="flex items-center justify-between h-16">
                <div class="flex items-center">
                    <div class="flex-shrink-0">
                        <img class="h-8 w-8" src="https://tailwindui.com/img/logos/workflow-mark-indigo-500.svg" alt="Workflow">
                    </div>
                    <div class="hidden md:block">
                        <div class="ml-10 flex items-baseline space-x-4">
                            <a href="/admin" class="text-gray-300 hover:bg-gray-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium">Dashboard</a>

                            <a href="/admin/addRooms" class="text-gray-300 hover:bg-gray-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium">Room</a>

                            <a href="/admin/userdetails" class="bg-gray-900 text-white px-3 py-2 rounded-md text-sm font-medium">User Details</a>

                            <a href="/admin/bookings" class="text-gray-300 hover:bg-gray-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium">Booking Details</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="md:hidden" id="mobile-menu">
            <div class="px-2 pt-2 pb-3 space-y-1 sm:px-3">
                <a href="/admin" class="bg-gray-900 text-white px-3 py-2 rounded-md text-sm font-medium">Dashboard</a>

                <a href="/admin/addRooms" class="text-gray-300 hover:bg-gray-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium">Room</a>

                <a href="/admin/userdetails" class="text-gray-300 hover:bg-gray-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium">User Details</a>

                <a href="/admin/bookings" class="text-gray-300 hover:bg-gray-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium">Booking Details</a>
            </div>
        </div>
    </nav>

    <header class="bg-white shadow">
        <div class="max-w-7xl mx-auto py-6 px-4 sm:px-6 lg:px-8" style = "display: flex; justify-content: space-around; align-items: center">
            <h1 class="text-3xl font-bold text-gray-900">
                User Details
            </h1>
        </div>
    </header>
</div>

    <!-- Search Bar -->
    <div class="search__container">
        <form action = "/admin/getUserByEmail" method="GET">
            <div class="bg-white shadow p-4 flex">
            <span class="w-auto flex justify-end items-center text-gray-500 p-2">
                <em class="material-icons text-3xl">search</em>
            </span>
                <input class="w-full rounded p-2" type="text" name = "email" placeholder="Search Email">
                <button class="bg-red-400 hover:bg-red-300 rounded text-white p-2 pl-4 pr-4" type = "submit">
                    <p class="font-semibold text-xs">Search</p>
                </button>
            </div>
        </form>
    </div>

    <!-- Table -->
    <div class = "table__content">
        <div class="flex flex-col">
            <div class="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-0">
                <div class="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
                    <div class="shadow overflow-hidden border-b border-gray-200 sm:rounded-lg">
                        <%
                            if (request.getAttribute("user_info") != null && session.getAttribute("userinfobyemail") == null && session.getAttribute("message") != "invalid") {
                        %>
                        <table class="min-w-full divide-y divide-gray-200" aria-describedby="list of rooms">
                            <thead class="bg-gray-50">
                                <tr>
                                    <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                        FIRST NAME
                                    </th>
                                    <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                        LAST NAME
                                    </th>
                                    <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                        EMAIL
                                    </th>
                                    <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                        ROLE
                                    </th>
                                    <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                        MOBILE NUMBER
                                    </th>
                                </tr>
                            </thead>
                            <tbody class="bg-white divide-y divide-gray-200">
                            <c:forEach items = '${user_info}' var = "userinfo">
                                <tr>
                                    <td class="px-6 py-4 whitespace-nowrap">
                                        <div class="flex items-center">
                                            <div class="ml-4">
                                                <div class="text-sm font-medium text-gray-900 text-center">
                                                        ${userinfo.firstName}
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-purple-800">
                                            ${userinfo.lastName}
                                    </td>
                                    <td class="px-6 py-4 whitespace-nowrap">
                                        <div class="text-sm text-gray-900">${userinfo.email}</div>
                                    </td>
                                    <td class="px-6 py-4 whitespace-nowrap">

                                        <c:choose>
                                            <c:when test="${userinfo.role == 'USER'}">
                                                     <span class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-green-100 text-green-800">
                                                         USER
                                                     </span>
                                            </c:when>
                                            <c:otherwise>
                                                     <span class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-red-100 text-red-800">
                                                         ADMIN
                                                     </span>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td class="px-6 py-4 whitespace-nowrap">
                                        <div class="text-sm text-gray-900">${userinfo.mobileNumber}</div>
                                    </td>
                                </tr>
                            </c:forEach>
                            <%
                                } else if (session.getAttribute("userinfobyemail") != null && session.getAttribute("message") == "valid") {
                            %>
                            <table class="min-w-full divide-y divide-gray-200" aria-describedby="list of rooms">
                                <thead class="bg-gray-50">
                                <tr>
                                    <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                        FIRST NAME
                                    </th>
                                    <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                        LAST NAME
                                    </th>
                                    <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                        EMAIL
                                    </th>
                                    <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                        ROLE
                                    </th>
                                    <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                        MOBILE NUMBER
                                    </th>
                                </tr>
                                </thead>
                                <tbody class="bg-white divide-y divide-gray-200">
                                    <tr>
                                        <td class="px-6 py-4 whitespace-nowrap">
                                            <div class="flex items-center">
                                                <div class="ml-4">
                                                    <div class="text-sm font-medium text-gray-900 text-center">
                                                            ${userinfobyemail.firstName}
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                        <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-purple-800">
                                                ${userinfobyemail.lastName}
                                        </td>
                                        <td class="px-6 py-4 whitespace-nowrap">
                                            <div class="text-sm text-gray-900">${userinfobyemail.email}</div>
                                        </td>
                                        <td class="px-6 py-4 whitespace-nowrap">
                                            <c:choose>
                                                <c:when test="true">
                                                         <span class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-green-100 text-green-800">
                                                             USER
                                                         </span>
                                                </c:when>
                                                <c:otherwise>
                                                         <span class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-red-100 text-red-800">
                                                             ADMIN
                                                         </span>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td class="px-6 py-4 whitespace-nowrap">
                                            <div class="text-sm text-gray-900">${userinfobyemail.mobileNumber}</div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <%
                            } else {
                            %>
                                <div class="data__message"> <h1>No data are Available...</h1></div>
                            <%
                                }
                            %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>