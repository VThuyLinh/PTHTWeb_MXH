


function showDate(a)
{
    let data1= a.slice(0,10);
    let data2= data1.split("-");
    let data= data2.reverse();
     document.getElementById('date').innerHTML = "Ngày tổ chức: " + data[0] + "-"+data[1]+"-"+data[2];
}


function deletePost(endpoint, postId) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(endpoint, {
            method: "delete"
        }).then(res => {
            if (res.status === 204) {
                let d = document.getElementById(`post${postId}`);
                d.style.display = "none";
            } else
                alert("Something Wrong!");
        });
    }
}

function deleteUser(endpoint, userId) {
    if (confirm("Bạn chắc chắn xóa ngu?i dùng này không?") === true) {
        fetch(endpoint, {
            method: "delete"
        }).then(res => {
            if (res.status === 204) {
                let d = document.getElementById(`user${userId}`);
                d.style.display = "none";
            } else
                alert("Something Wrong!");
        });
    }
}


function deleteComment(endpoint, commentId) {
    if (confirm("Bạn chắc chắn xóa comment không?") === true) {
        fetch(endpoint, {
            method: "delete"
        }).then(res => {
            if (res.status === 204) {
                let d = document.getElementById(`comment${commentId}`);
                d.style.display = "none";
            } else
                alert("Something Wrong!");
        });
    }
}


    
   