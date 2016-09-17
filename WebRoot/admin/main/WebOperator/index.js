Ext.onReady(function(){
	//指定每页显示的条数
	var itemsPerPage = 10;
	//创建表格数据模型
	Ext.define('WebOperator', {
	    extend: 'Ext.data.Model',
	    fields: ['accountID','webOperatorID','operatorName','password1',
	             'password2','password3','password4',
	             'sex','operatorUid','mobile','createDate',
	             'operatorFunction','state','operatorType','simNo',
	             'deviceNo','authenticationID','language','isBind']
	});
	//定义数据源
	var webOperatorStore = Ext.create('Ext.data.Store',{
		autoLoad:{start:0,limit:itemsPerPage},
		model:'WebOperator',
		pageSize:itemsPerPage,
		proxy:{
			type:'ajax',
			url:'webOperator/webOperator_getWebOperatorInfo.action',
			reader:{
				type:'json',
				totalProperty:'results',
				root:'rows'
			}
		}
	});
	//创建工具栏
	var toolbar = [
	{text:'新增客户',iconCls:'add',handler:showAdd},
	{text:'修改客户',iconCls:'update',handler:showUpdate},
	{text:'删除删除',iconCls:'delete',handler:showDelete}
	];
	
	//创建表格
	var webOperatorGrid = Ext.create('Ext.grid.Panel',{
		tbar:toolbar,
		region:'center',
		store:webOperatorStore,
		selModel:new Ext.selection.CheckboxModel(),
		columns:[
		{text:'accountID',width:80,dataIndex:'accountID',sortabel:true},
		{text:'webOperatorID',width:80,dataIndex:'webOperatorID'},
		{text:'operatorName',width:80,dataIndex:'operatorName'},
		{text:'password1',width:80,dataIndex:'password1'},
		{text:'password2',width:80,dataIndex:'password2'},
		{text:'password3',width:80,dataIndex:'password3'},
		{text:'password4',width:80,dataIndex:'password4'},
		{text:'sex',width:80,dataIndex:'sex'},
		{text:'operatorUid',width:80,dataIndex:'operatorUid'},
		{text:'mobile',width:80,dataIndex:'mobile'},
		{text:'createDate',width:250,dataIndex:'createDate'},
		{text:'operatorFunction',width:80,dataIndex:'operatorFunction'},
		{text:'state',width:80,dataIndex:'state'},
		{text:'operatorType',width:80,dataIndex:'operatorType'},
		{text:'simNo',width:80,dataIndex:'simNo'},
		{text:'deviceNo',width:80,dataIndex:'deviceNo'},
		{text:'authenticationID',width:80,dataIndex:'authenticationID'},
		{text:'language',width:80,dataIndex:'language'},
		{text:'isBind',width:80,dataIndex:'isBind'}
		],
		bbar:[{
			xtype:'pagingtoolbar',
			store: webOperatorStore,
			width:600,
			displayInfo:true
		}]
	});
	
	//创建viewport
	Ext.create('Ext.container.Viewport',{
		layout:'border',
		items:[webOperatorGrid]
	});
	
	//创建表单
	Ext.QuickTips.init();
	
	var schoolForm = Ext.create('Ext.form.Panel',{
		filedDefault:{
			labelSeparator:':',
			labelWidth:80,
			msgTarget:'side',
			width:300
		},
		bodyPadding:5,
		frame:true,
		items:[{
			xtype:'textfield',
			name:'school.schoolName',
			id:'schoolName',
			allowBlank:false,
			fieldLabel:'校区名称'
		},{
			xtype:'textfield',
			name:'school.schoolPhone',
			id:'schoolPhone',
			allowBlank:false,
			fieldLabel:'校区电话'
		},{
			xtype:'textfield',
			name:'school.schoolAddress',
			id:'schoolAddress',
			allowBlank:false,
			fieldLabel:'校区地址'
		},{
			xtype:'hidden',
			name:'school.id',
			id:'id'
		}],
		buttons:[{text:'提交',handler:submitForm},
		        {text:'关闭',handler:function(){win.hide();}}
		]
	});
	
	//创建窗口
	var win = Ext.create('Ext.window.Window',{
		layout:'fit',
		width:300,
		closeAction:'hide',
		height:280,
		resizeavle:false,
		closeable:true,
		items:[schoolForm]
	});
	
	function submitForm() {
		if(schoolForm.isAdd) {
		schoolForm.form.submit({
			clientValidation:true,
			waitMsg:'正在提交数据请稍后',
			waitTitle:'提示',
			url:'webOperator/webOperator_add.action',
			method:'POST',
			success:function(form,action) {
				win.hide();
				Ext.Msg.alert('提示','添加信息成功');
				webOperatorStore.load();
			},
			failure:function(form,action) {
				Ext.Msg.alert('提示','添加信息失败');
			}
		});
		} else {
			schoolForm.form.submit({
				clientValidation:true,
				waitMsg:'正在提交数据请稍后',
				waitTitle:'提示',
				url:'webOperator/webOperator_update.action',
				method:'POST',
				success:function(form,action) {
					win.hide();
					Ext.Msg.alert('提示','修改成功');
					webOperatorStore.load();
				},
				failure:function(form,action) {
					Ext.Msg.alert('提示','修改失败');
				}
			});
		}
	}
	
	//显示添加
	function showAdd() {
		schoolForm.form.reset();
		schoolForm.isAdd = true;
		win.setTitle('新增用户');
		win.show();
	}
	
	//显示修改
	function showUpdate() {
		//获取对应的id
		var idList = getWebOperatorIdList();
		var num = idList.length;
		if(num>1) {
			Ext.Msg.alert('提示','每次只能操作一条数据');
		} else {
			schoolForm.form.reset();
			win.setTitle('修改用户');
			win.show();
			loadForm(idList[0]);
		}
	}
	
	function getWebOperatorIdList() {
		var recs = webOperatorGrid.getSelectionModel().getSelection();
		var idList = [];
		if(recs.length==0) {
			Ext.Msg.alert('提示','请选择你需要操作的数据');
			return;
		} else {
			for(var i=0;i<recs.length;i++) {
				var rec = recs[i];
				idList.push(rec.get('id'));
			}
		}
		return idList;
	}
	
	function loadForm(id) {
		schoolForm.form.load({
			waitMsg:'正在加载数据请稍后',
			waitTitle:'提示',
			url:'webOperator/webOperator_getSchoolById.action',
			params:{id:id},
			failure:function(form,action) {
				Ext.Msg.alert('提示','修改失败');
			}
		});
	}
	
	function showDelete() {
		var idList = getWebOperatorIdList();
		var num = idList.length;
		if(num==0) {
			Ext.Msg.alert('提示','请选择你需要操作的数据');
			return;
		} else {
			Ext.Msg.confirm('提示','确定删除对应的数据吗？',function(btn) {
				if(btn=='yes') {
					deleteWebOperator(idList);
				}
			});
		}
	}
	
	function deleteWebOperator(idList) {
		var ids = idList.join(',');
		var msgTip = Ext.Msg.show({
			title:'提示',
			width:250,
			msg:'正在删除数据请稍后...'
		});
		Ext.Ajax.request({
			url:'webOperator/webOperator_delete.action',
			params:{ids:ids},
			method:'POST',
			success:function(form,action) {
				msgTip.hide();
				Ext.Msg.alert('提示','删除成功');
				webOperatorStore.load();
			},
			failure:function(form,action) {
				msgTip.hide();
				Ext.Msg.alert('提示','删除失败');
			}
		});
		
	}
});