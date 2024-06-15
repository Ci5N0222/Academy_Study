class Exam03 extends Phaser.Scene {
    constructor(){
        super({key:"Exam03"});
        this.tileSpeed = 2;
        this.jumpCount = 0;
        this.timer = 0;
        this.frame = 0;
        this.score = 0;
        this.items = [];
    }

    preload(){
        this.load.image("player", "images/play.gif");
        this.load.image("bg", "images/am-bg.png");
        this.load.image("item", "images/item.png");
        this.load.spritesheet("amongUsRun", "images/amongRun.png", {frameWidth: 237/8, frameHeight: 29});
        this.load.spritesheet("amongUsJump", "images/amongJump.png", {frameWidth: 316/10, frameHeight: 29});
    }

    create(){
        // 배경
        this.background = this.add.tileSprite(0, 0, this.cameras.main.width, this.cameras.main.height, "bg");
        this.background.setOrigin(0, 0);

        this.anims.create({
            key: "run",
            frames: this.anims.generateFrameNumbers("amongUsRun", {start:0, end:7}),
            frameRate: 11,
            repeat: -1
        });

        this.anims.create({
            key:"jump",
            frames: this.anims.generateFrameNumbers("amongUsJump", {start:0, end:9}),
            frameRate: 12,
            repeat: 1
        })

        // 플레이어 케릭터
        this.player = this.physics.add.sprite(80, this.cameras.main.height-200, "amongUsRun");
        this.player.setCollideWorldBounds(true);
        let playerScaleFactor = 4;
        this.player.setScale(playerScaleFactor);
        this.player.setSize(50/playerScaleFactor, 80/playerScaleFactor);
        this.player.setGravity(0, 1000);
        this.player.anims.play({key:"run"});
        this.player.setData("onfloor", true);

        // 바닥
        let floor = this.add.rectangle(0, this.cameras.main.height-30, this.cameras.main.width, 5, 0x0000, 0);
        floor.setOrigin(0, 0);
        this.physics.add.existing(floor, true);

        this.physics.add.collider(floor, this.player, (floor, player) => {
            player.setData("onFloor", true);
        });

        // 좌측 벽
        let finalBoundary = this.add.rectangle(this.cameras.main.height-20, 0, 5, this.cameras.main.height, 0x0000);
        finalBoundary.setOrigin(100, 0);
        this.physics.add.existing(finalBoundary, true);

        // 아이템이 좌측 으로 지나갈 경우 item 인스턴스 제거
        this.physics.add.collider(finalBoundary, this.items, (final, item) => {
            item.destroy();
        });

        // 아이템을 먹었을 때 효과
        this.physics.add.overlap(this.player, this.items, (player, item) => {
            item.destroy();
            this.score += 100;
            document.querySelector("#score").innerHTML = this.score;
        });

        // 키보드 이벤트 추가
        this.cursor = this.input.keyboard.createCursorKeys();
    }

    update(){
        this.frame++;
        if(this.frame%60 === 0) {
            this.timer++;
            document.querySelector("#timer").innerHTML = this.timer;
        }

        if(this.frame%40 == 0) {
            let item = this.physics.add.sprite(720, Math.random()*(360-110+1)+110, "item");
            let itemScaleFactor = 1;
            item.setScale(itemScaleFactor);
            item.setSize(40/itemScaleFactor, 50/itemScaleFactor);
            item.setVelocityX(-150);
            this.items.push(item);
        }

        this.background.tilePositionX += this.tileSpeed;

        if(this.cursor.left.isDown) {
            this.player.setVelocityX(-250);
        } else if(this.cursor.right.isDown) {
            this.player.setVelocityX(250);
        } else {
            this.player.setVelocityX(0);
        }

        if(Phaser.Input.Keyboard.JustDown(this.cursor.space)){
            if(this.jumpCount < 2){
                this.player.setVelocityY(-500);
                this.player.play("jump");
                this.player.setData("onFloor", false);
                this.jumpCount++;
            }
        }

        if(this.player.getData("onFloor") && this.player.anims.currentAnim.key !== "run"){
            this.player.play("run");
            this.jumpCount = 0;
        }

    }
}