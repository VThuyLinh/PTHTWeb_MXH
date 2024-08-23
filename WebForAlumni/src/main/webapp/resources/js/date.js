


function showDate(a)
{
    let data1 = a.slice(0, 10);
    let data2 = data1.split("-");
    let data = data2.reverse();
    document.getElementById('date').innerHTML = "Ngày tổ chức: " + data[0] + "-" + data[1] + "-" + data[2];
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
                let d = document.getElementById(`cmt${commentId}`);
                d.style.display = "none";
            } else
                alert("Something Wrong!");
        });
    }
}

function deleteNotification(endpoint, noId) {
    if (confirm("Bạn chắc chắn xóa comment không?") === true) {
        fetch(endpoint, {
            method: "delete"
        }).then(res => {
            if (res.status === 204) {
                let d = document.getElementById(`no${noId}`);
                d.style.display = "none";
            } else
                alert("Something Wrong!");
        });
    }
}



function upDateActivePost (endpoint, noId) {
    if (confirm("Bạn chắc chắn khóa không?") === true) {
        fetch(endpoint, {
       
        method: "PATCH",
        body: JSON.stringify({"active":0})
        }).then(res => {
            if (res.status === 200)
                alert("OK");
        });
    }
}



function getDate()
        {
        var curDate = new Date();
                document.getElementById('createdDate').valueOf = curDate.getTime();
                // return TRUE/FALSE;
                }




   