class Exam01 extends Phaser.Scene {

    // Scene에서 사용할 변수나 ㅎ마수를 초기화 하는 곳
    constructor(){
        super("Exam01");
    }

    // Scene에 사용될 이미지, 음악, 영상등의 자원을 로딩하는 곳 ( RAM에 적재 작업 )
    preload(){
        
    }

    // RAM에 적재된 자원을 바탕으로 인스턴스를 생성하는 곳
    create(){
        this.cameras.main.setBackgroundColor("#FFFFFF");

        // 플레이어 주인공 케릭터
        this.player = this.physics.add.sprite(10, 250, 100, 100);
        this.player.setCollideWorldBounds(true);

        // 장애물 추가
        this.box = this.physics.add.sprite(250, 250, 100, 100);
        this.box.setCollideWorldBounds(true);
        // 충돌 시 움직임 없음 (장애물 또는 벽으로 사용 가능)
        // this.box.setImmovable(true);
        // 탄성
        this.box.setBounce(1);
        // 공기 저항
        this.box.setDrag(10);
        // sprite의 질량 값
        this.box.setMass(5);

        // 충돌 정보 추가
        this.physics.add.collider(this.player, this.box, function(player, box){
            console.log("충돌 감지");
        });

        // 키보드 조작을 위한 인스턴스
        this.cursor = this.input.keyboard.createCursorKeys();
    }

    // 무한루프를 반복하며 게임 내용을 채우는 곳 ( 기본 60fps )
    update(){
        if(this.cursor.left.isDown) {
            this.player.setVelocityX(-200);
        } else if(this.cursor.right.isDown) {
            this.player.setVelocityX(200);
        } else {
            this.player.setVelocityX(0);
        }
        
        if(this.cursor.up.isDown) {
            this.player.setVelocityY(-200);
        } else if(this.cursor.down.isDown) {
            this.player.setVelocityY(200);
        } else {
            this.player.setVelocityY(0);
        }
    }

}