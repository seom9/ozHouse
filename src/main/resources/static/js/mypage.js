$(function(){ 	
    function executeScrap() {
        let product_num = $("#product_num").val();
        $.ajax({
            type: 'post',
            url: 'scrap_product.do',
            data: { 'product_num': product_num },
            success: function(data) { 
                if (data === 'Y') {
                    alert('상품이 스크랩 되었습니다');
                } else if (data === 'N') {
                    alert('이미 스크랩한 상품입니다');
                }
            },
            error: function(error) {
                alert(error);
            }
        });
    }

    // doScrap 버튼 클릭 이벤트 핸들러 등록
    $("#doScrap").click(executeScrap);
});

