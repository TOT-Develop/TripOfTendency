//  URL 선언
const BASE_TREVIEW_URL = '/totreviews/admin/review'; // 여행 후기 기본 URL
const ALL_ADMIN_ACTIVE_TREVIEW_URL = `${BASE_TREVIEW_URL}/1/1`; // 활성화 게시물 조회 URL
const ALL_ADMIN_DEACTIVE_TREVIEW_URL = `${BASE_TREVIEW_URL}/2/1`; // 비활성화 게시물 조회 URL

// 에러 메시지 선언
const ERROR_MESSAGES = {
    NOT_SELECT_TREVIEW: '하나 이상의 후기 게시물을 선택해야 합니다.',
    FAIL_UPDATE_TREVSTATUS: '상태 변경 중 오류가 발생했습니다'
};

$(document).ready(() => {
    // 현재 경로에 따라 버튼 활성화
    let path = window.location.pathname;

    if (path.includes(ALL_ADMIN_ACTIVE_TREVIEW_URL)) {
        $('#activeBtn').addClass('active');
        $('#deactiveBtn').removeClass('active');
    } else if (path.includes(ALL_ADMIN_DEACTIVE_TREVIEW_URL)) {
        $('#deactiveBtn').addClass('active');
        $('#activeBtn').removeClass('active');
    }

    // 활성화 버튼 클릭 시 활성화 게시물 목록 처리
    $('#activeBtn').on('click', () => {
        window.location.href = ALL_ADMIN_ACTIVE_TREVIEW_URL;
    });

    // 비활성화 버튼 클릭 시 비활성화 게시물 목록 처리
    $('#deactiveBtn').on('click', () => {
        window.location.href = ALL_ADMIN_DEACTIVE_TREVIEW_URL;
    });

    // 게시물 관리 전체 선택 및 해제
    $("#selectAll").change(function (e) {
        $("input[name='reviewSelect']").prop("checked", this.checked);
    });
    
    // 게시물 활성화, 비활성화 처리
    $('.activeButton').on('click', function (e) {
        e.preventDefault();
        e.stopPropagation();

        const selectedReviews = $("input[name='reviewSelect']:checked").map(function () {
            return $(this).val();
        }).get();

        if (selectedReviews.length === 0) {
            alert(ERROR_MESSAGES.NOT_SELECT_TREVIEW);
            return;
        }

        const url = $(this).attr('href');

        $.ajax({
            type: 'POST',
            url: url,
            contentType: 'application/json',
            data: JSON.stringify(selectedReviews),
            success: function (response) {
                alert(response.message);
                location.reload();
            },
            error: function (xhr, status, error) {
                alert(ERROR_MESSAGES.FAIL_UPDATE_TREVSTATUS);
                console.log(error);
            }
        });
    });

    // 뒤로가기 버튼 클릭 시 뒤로 이동
    $('.backBtn').on('click', function () {
        window.history.back();
    });

});