<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Sorting Number</h1>
       <form:form method="post" action="sorting">  
      	<table >  
         <tr>  
          <td>Enter size of list to be sorted :</td>  
          <td> <input type="text" name="enteredValue" />
         </tr>
         
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Submit" /></td>  
         </tr>  
        </table>  
       </form:form>  
