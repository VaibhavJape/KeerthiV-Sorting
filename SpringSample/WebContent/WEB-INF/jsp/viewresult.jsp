    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Sorting Result</h1>
	<table>
    <tr>
    <td>Random Number : ${sorting.actual}</td>
    </tr>
    <tr>
    <td></td>
    </tr>
    <tr>
    <td>Sorting Number    : ${sorting.result}</td>  </tr>
    <tr>
    <tr>
    <td></td>
    </tr>
    <tr>
    <td>Position Count   	: ${sorting.count}</td>
    </tr>
    <tr>
    <td></td>
    </tr>
    <tr>
    <td>Time Taken  		: ${sorting.time} milliseconds</td>
    </tr>
    </table>