$(function(){
	$("[name=companyname]").blur(function(){
		change();
	});
    $("[name=cdescribe]").blur(function(){
        change();
    });
    $("[name=cname]").blur(function(){
        change();
    });
});

function change(){
    var companyname = $("[name=companyname]").val();
    var cdescribe = $("[name=cdescribe]").val();
    var cname = $("[name=cname]").val();

        $.ajax({
            url:"sell_json",
            type:"post",
            data:{"companyname":companyname,"cdescribe":cdescribe,"cname":cname,"p":"2"},
            dataType:"json",
            success:function(data){
                $.each(data.list,function(index,k){

                },window.location.href="sell_jsonShow");

            }
        })

}