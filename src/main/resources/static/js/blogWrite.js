function handleFocus(input) {
    input.placeholder = '';
}

function handleBlur(input) {
	if (!input.value) {
		input.placeholder = '어떤 사진인지 짧은 소개로 시작해보세요.';
	}
}

function handleBlu2(input) {
	if (!input.value) {
		input.placeholder = '어떤 동영상인지 짧은 소개로 시작해보세요.';
	}
}
		
function handleBlurr(input) {
	if (!input.value) {
		input.placeholder = '제목을 작성해주세요.';
	}
}
		
function hideDefaultOption() {
	var spaceSelect = document.getElementById('spaceSelect');
    var defaultOption = spaceSelect.querySelector('option[disabled]');
    
    defaultOption.classList.add('hidden');
}

$(document).ready(function() {
	
	// 처음 버튼을 눌렀을 때 실행
	$(".button_box").on("click", function(){
		$("#blog_image").click();
		console.log("버튼이 눌러졌습니다.");
	})
	
	$("#blog_image").on("change", function(e){		
		previewImage(e);
	})
	
	function previewImage(e){
		console.log("이미지 미리보기 실행");
		
		var reader = new FileReader();
		var str = "";
        var fileInput = document.getElementById('blog_image');
        var fileName = (fileInput.files.length > 0) ? fileInput.files[0].name : null;
		
		reader.onload = function(){
			console.log("미리보기 실행중");
			
            str += "<div class='img_box'>";
            str += "<img src='" + reader.result + "' name='blog_image' id='" + fileName + "'class='bbb'>";
            str += "<div class='overlay'>";
            str += "<button class='reinput_image' title='사진 다시 올리기'>";
            str += "<svg xmlns='http://www.w3.org/2000/svg' height='20' width='20' viewBox='0 0 512 512'><!--!Font Awesome Free 6.5.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2024 Fonticons, Inc.--><path d='M125.7 160H176c17.7 0 32 14.3 32 32s-14.3 32-32 32H48c-17.7 0-32-14.3-32-32V64c0-17.7 14.3-32 32-32s32 14.3 32 32v51.2L97.6 97.6c87.5-87.5 229.3-87.5 316.8 0s87.5 229.3 0 316.8s-229.3 87.5-316.8 0c-12.5-12.5-12.5-32.8 0-45.3s32.8-12.5 45.3 0c62.5 62.5 163.8 62.5 226.3 0s62.5-163.8 0-226.3s-163.8-62.5-226.3 0L125.7 160z'/></svg>";
            str += "</button>";
            str += "<button class='delete_image'>";
            str += "<svg xmlns='http://www.w3.org/2000/svg' height='20' width='20' viewBox='0 0 448 512'><!--!Font Awesome Free 6.5.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2024 Fonticons, Inc.--><path d='M135.2 17.7C140.6 6.8 151.7 0 163.8 0H284.2c12.1 0 23.2 6.8 28.6 17.7L320 32h96c17.7 0 32 14.3 32 32s-14.3 32-32 32H32C14.3 96 0 81.7 0 64S14.3 32 32 32h96l7.2-14.3zM32 128H416V448c0 35.3-28.7 64-64 64H96c-35.3 0-64-28.7-64-64V128zm96 64c-8.8 0-16 7.2-16 16V432c0 8.8 7.2 16 16 16s16-7.2 16-16V208c0-8.8-7.2-16-16-16zm96 0c-8.8 0-16 7.2-16 16V432c0 8.8 7.2 16 16 16s16-7.2 16-16V208c0-8.8-7.2-16-16-16zm96 0c-8.8 0-16 7.2-16 16V432c0 8.8 7.2 16 16 16s16-7.2 16-16V208c0-8.8-7.2-16-16-16z'/></svg>";
            str += "</button>"; 
            str += "</div>";
            str += "</div>";
            
            $(".button_box").remove();
            $(".contents_box_1_2").append(str);
            
            // 새로운 li 요소 추가
            addLi(reader, fileName);
            
            // addButton 추가
            addButton(fileName);
		};
		
		console.log("미리보기 실행");
		reader.readAsDataURL(e.target.files[0]);
	}
	
	// 새로운 li 요소 추가
	function addLi(reader, fileName) {
	    var liStr = "";

	    var dynamicId = "dynamicLi_" + Date.now();

	    liStr += '<li id="' + dynamicId + '">';
	    liStr += '    <div>';
	    liStr += '        <button class="css-1sdruza" type="button">';
	    liStr += '            <div class="css-1b5f9f1"></div>';
	    liStr += '        </button>';
	    liStr += '        <div class="css-o9d932">';
	    liStr += '            <div class="css-s5xdrg">';
	    liStr += '                <div class="css-1q8d1he" data-file-name="' + fileName + '" draggable="true">';
	    liStr += '                    <img class="css-1cqverl" src="' + reader.result + '">';
	    liStr += '                </div>';
	    liStr += '            </div>';
	    liStr += '        </div>';
	    liStr += '        <button class="css-1sdruza" type="button">';
	    liStr += '            <div class="css-1b5f9f1"></div>';
	    liStr += '        </button>';
	    liStr += '    </div>';
	    liStr += '</li>';

	    $('.css-kjmyv4').append(liStr);
	    $('.css-kjmyv4 .add_button').hide();
	    addButton(dynamicId);
	}

	// add_button 생성
	function addButton(liId) {
	    var buttonStr = "";

	    buttonStr += "<div class='abc'>";
	    buttonStr += "<input type='file' id='aa' name='blog_image' hidden>";
	    buttonStr += "<button type='button' class='add_button'>";
	    buttonStr += "<span class='add_button2'> + </span>";
	    buttonStr += "</button>";
	    buttonStr += "</div>";

	    $('#' + liId).append(buttonStr);

	}

    
    $(document).on("click", ".add_button", function(){
        $(this).closest('.abc').find('input[type=file]').click();
        console.log("플러스 버튼 클릭했다.");
    })
    
    $(document).on("change", "#aa", function(e){
        console.log("두번째 미리보기 function 진행");
        previewImage2(e);
        
        var blogImages = $("input[name='blog_image']");
        var test = $("input[name='blog_subject'");
        blogImages.each(function(index) {
            var value = $(this).val(); // 현재 반복되고 있는 input 요소의 값 읽기
            console.log("Value of blog_image #" + (index + 1) + ": " + value);
            console.log("test #" + (index + 1) + ": " + value)
        });
        
        test.each(function(index) {
            var value = $(this).val(); // 현재 반복되고 있는 input 요소의 값 읽기
            console.log("test #" + (index + 1) + ": " + value)
        });
        
    });
    
    function previewImage2(e){
    	console.log("두번째 미리보기 실행")
    	
		var reader = new FileReader();
		var str = "";
        var fileInput = document.getElementById('aa');
        var fileName = (fileInput.files.length > 0) ? fileInput.files[0].name : null;
        
        reader.onload = function(){
            // 새로운 li 요소 추가
            addLi(reader, fileName);
            console.log("새로운 li요소 추가 완료");
            add_clone(reader, fileName);
            console.log("새로운 클론 추가 완료");
        };
        
		console.log("미리보기 실행");
		reader.readAsDataURL(e.target.files[0]);
    }
    
    function add_clone(reader, fileName) {
    	var addClone = $(".contents_2:last").clone();
    	
    	addClone.find('.css-kjmyv4').remove(); // .css-kjmyv4를 삭제
    	
        // 이미지 속성 변경 (첫 번째 자식 요소의 img 태그)
        addClone.find('.img_box > :first-child').attr({
            'src': reader.result,
            'id': fileName
        });
        
        // 값 초기화
        addClone.find('.explain2').val('').blur(); // input 초기화 및 포커스 아웃
        addClone.find('.explain_box2').val('').blur(); // textarea 초기화 및 포커스 아웃
        
        $(".contents").append(addClone);

    }
    
});