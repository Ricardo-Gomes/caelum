<%@ attribute name="id" required="true" %>

<input id="${id}" name="${id}" type="text">
<script>
$("#${id}").datepicker({dateFormat: 'dd/mm/yy'});
</script>