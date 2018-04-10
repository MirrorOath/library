var url;

function changeToRegister(){
	$('#dg').dialog('close');
	$('#lgfm').form('clear');
	$('#dlg').dialog('open');
}
function changeToLogin(){
	$('#dlg').dialog('close');
	$('#rgfm').form('clear');
	$('#dg').dialog('open');
}

function clearNow(){
	$('#lgfm').form('clear');
}

function ss(){
	var row = $('#dlg').datagrid('getSelected');
	$('#dlg').dialog('close');
	if (row){
		$('#dg').dialog('open').dialog('setTitle','Edit User');
		$('dg').form('load', row);
	}
}
function newUser(){
	$('#dlg').dialog('open').dialog('setTitle','添加用户');
	$('#fm').form('clear');
	url = '${pageContext.request.contextPath }/admin/new_user.action';
}
function editUser(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$('#dlg').dialog('open').dialog('setTitle','Edit User');
		row["date"] = formatDate(row["date"], row); // 修改日期格式
		$('#fm').form('load',row);
		url = '${pageContext.request.contextPath }/admin/update_user.action';
	}
}
function saveUser(){
	$('#fm').form('submit',{
		url: '${pageContext.request.contextPath }/user/register_user.action',
		onSubmit: function(){
			return $(this).form('validate');
		},
		success: function(result){
			var result = eval('('+result+')');
			if (result.success){
				$('#dlg').dialog('close');		// close the dialog
				$('#dg').datagrid('reload');	// reload the user data
			} else {
				$.messager.show({
					title: '用户名已存在,注册失败',
					msg: result.msg
				});
			}
		}
	});
}
function removeUser(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$.messager.confirm('Confirm','你确定要删除这个用户吗',function(r){
			if (r){
				$.post('${pageContext.request.contextPath }/admin/del_user.action',{id:row.id},function(result){
					if (result.success){
						$('#dg').datagrid('reload');	// reload the user data
					} else {
						$.messager.show({	// show error message
							title: 'Error',
							msg: result.msg
						});
					}
				},'json');
			}
		});
	}
}
function formatDate(val, row){
	var date = new Date(val);
	return date.getFullYear()+"年"+date.getMonth()+"月"+date.getDate()+"日";
}