
$(function(){
	$('#ff').form({
		url:'form3_proc.php',
		onSubmit:function(){
			return $(this).form('validate');
		},
		success:function(data){
			$.messager.alert('Info', data, 'info');
		}
	});
});

$(function () {

    $.extend($.fn.validatebox.defaults.rules, {
        phone: {
            validator: function (value) {
                return /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/i.test($.trim(value)); 
　　　　}, 
　　　　message:'联系电话格式错误.' } });


    $.extend($.fn.validatebox.defaults.rules, {
        userName: {
            validator: function (value) {
                return /^[a-z]\S{0,14}$/i.test($.trim(value)); 
　　　　}, 
　　　　message:'请以字母开头并在15个字符以内.' } });


　$.extend($.fn.validatebox.defaults.rules, {     
      　　 minLength: {     
          　　  validator: function(value, param){  
           　　     return value.length >= param[0];     
          　　  },     
         　　   message: '请输入最小{0}位字符.'    
      　　  }     
   　　 });   


})

