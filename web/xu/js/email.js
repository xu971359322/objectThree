$(function(){
    $("[name=person]").change(function () {
        var arr = new Array();
        $("input[name='person']:checked").each(function(i){
            arr[i] = $(this).val();
        });
        if(arr.length<=0){
            $("#meetPeople").html("");
        }else{
            $.ajax({
                url:"/email/selPerson.do",
                type:"post",
                contentType:"application/json;charset=utf-8",
                //dataType:"json",
                data:JSON.stringify(arr),
                success:function(data){
                    $("#meetPeople").html("");
                    for (var a in data){
                        var newChack ="<input type='checkbox' name='people' value="+data[a].woId+">"+data[a].woName;
                        $("#meetPeople").append(newChack);
                    }
                },error:function(){
                    alert("ajax出错")
                }
            })
        }

    });
});