class Exam04 extends Phaser.Scene {

    constructor(){
        super({key:"Exam04"});
    }

    preload(){
        this.load.image("rpg-bg", "images/rpg-bg.jpg");
    }

    create(){
        this.cameras.main.setBackgroundColor("#ffffff");

        let background = this.add.tileSprite(0, 0, 1218, 752, "rpg-bg");
        background.setOrigin(0, 0);

        this.me = this.physics.add.sprite(250, 250, 50, 50);
        // config에 설정한 넓이 높이만큼 경계를 그어버림
        // this.me.setCollideWorldBounds(true);

        // world bounds 추가
        this.physics.world.setBounds(0, 0, background.width, background.height);
        this.me.setCollideWorldBounds(true);
        this.cameras.main.setBounds(0, 0, background.width, background.height);
        this.cameras.main.startFollow(this.me);
        

        this.cursor = this.input.keyboard.createCursorKeys();
    }

    update(){

        if(this.cursor.left.isDown) {
            this.me.setVelocityX(-200);
        } else if(this.cursor.right.isDown) {
            this.me.setVelocityX(200);
        } else {
            this.me.setVelocityX(0);
        }
        
        if(this.cursor.up.isDown) {
            this.me.setVelocityY(-200);
        } else if(this.cursor.down.isDown) {
            this.me.setVelocityY(200);
        } else {
            this.me.setVelocityY(0);
        }
    }

}