class Exam02 extends Phaser.Scene {
    constructor(){
        super({key:"Exam02"});
        this.boxes = [];
        this.frame = 0;
        this.score = 0;
        this.timer = 0;
        this.tileSpeed = 2;
        this.boundary = [];
    }

    // Scene이 start 될 때마다 실행되는 함수 
    // Scene이 시작될때(또는 다시 시작될때) 초기화를 시켜주는 작업
    init(){
        this.timer = 0;
        this.score = 0;
        document.querySelector("#score").innerHTML = this.score;
    }

    preload(){
        this.load.image("player", "images/play.gif");
        this.load.image("monster", "images/mob.png");
        this.load.image("bg", "images/space.jpg");
        
    }

    create(){
        this.background = this.add.tileSprite(0, 0, this.cameras.main.width, this.cameras.main.height, "bg");
        this.background.setOrigin(0, 0);

        this.player = this.physics.add.sprite(250, 250, "player");
        // 내가 원하는 사이즈 / 원본 아미지 사이즈 = scalefactor
        let scaleFactor = 40/512;
        this.player.setScale(scaleFactor);
        this.player.setSize(25/scaleFactor, 30/scaleFactor);

        this.player.setCollideWorldBounds(true);

        let bottomBoundary = this.add.rectangle(0, this.cameras.main.height+20, this.cameras.main.width, 5, 0x0000);
        bottomBoundary.setOrigin(0, 0);
        this.physics.add.existing(bottomBoundary, true);

        let topBoundary = this.add.rectangle(0, this.cameras.main.height-20, this.cameras.main.width, 5, 0x0000);
        topBoundary.setOrigin(0, 100);
        this.physics.add.existing(topBoundary, true);

        let leftBoundary = this.add.rectangle(this.cameras.main.height-20, 0, 5, this.cameras.main.height, 0x0000);
        leftBoundary.setOrigin(100, 0);
        this.physics.add.existing(leftBoundary, true);

        let rightBoundary = this.add.rectangle(this.cameras.main.height+20, 0, 5, this.cameras.main.height, 0x0000);
        rightBoundary.setOrigin(0, 0);
        this.physics.add.existing(rightBoundary, true);

        this.boundary.push(bottomBoundary, topBoundary, leftBoundary, rightBoundary);
        
        for(let bound of this.boundary){
            this.physics.add.collider(this.boxes, bound, (box, boundary) => {
                box.destroy();
                this.score += 100;
                document.querySelector("#score").innerHTML = this.score;
                this.boxes.splice(this.boxes.indexOf(box), 1);
            });
        }
        
        this.physics.add.collider(this.boxes, this.player, (box, player) => {
            this.scene.start("GameOver");
            // player.destroy();
            // alert("점수 : "+this.score+"\n생존시간 : " +this.timer);
        });

        this.timerText = this.add.text(this.cameras.main.width-40, 10, '0', {
            fontSize: '26px',
            fill: '#FF0000'
        });

        this.cursor = this.input.keyboard.createCursorKeys();

    }

    update(){
        let scaleFactor = 40/512;
        this.background.tilePositionX += this.tileSpeed;

        this.frame++;
        if(this.frame%60 == 0){
            this.timer++;
            this.timerText.setText(this.timer);
            document.querySelector("#timer").innerHTML = this.timer;
        }

        if(this.frame%40 == 0){
            
            if(this.timer > 10) {
                this.tileSpeed = 10;

                let box1 = this.physics.add.sprite(Math.random()*(480-20+1)+20, 20, "monster");
                box1.setScale(scaleFactor);
                box1.setSize(25/scaleFactor, 30/scaleFactor);
                box1.setVelocityY(Math.random()*(200-100+1) + 100);

                let box2 = this.physics.add.sprite(Math.random()*(480-20+1)+20, 480, "monster");
                box2.setScale(scaleFactor);
                box2.setSize(25/scaleFactor, 30/scaleFactor);
                box2.setVelocityY(Math.random()*(100-200+1) - 100);

                let box3 = this.physics.add.sprite(20, Math.random()*(480-20+1)+20, "monster");
                box3.setScale(scaleFactor);
                box3.setSize(25/scaleFactor, 30/scaleFactor);
                box3.setVelocityX(Math.random()*(200-100+1) + 100);

                let box4 = this.physics.add.sprite(480, Math.random()*(480-20+1)+20, "monster");
                box4.setScale(scaleFactor);
                box4.setSize(25/scaleFactor, 30/scaleFactor);
                box4.setVelocityX(Math.random()*(100-200+1) - 100);
                    
                this.boxes.push(box1, box2, box3, box4);

            } else if(this.timer > 5) {
                this.tileSpeed = 5;
                let box1 = this.physics.add.sprite(Math.random()*(480-20+1)+20, 20, "monster");
                box1.setScale(scaleFactor);
                box1.setSize(25/scaleFactor, 30/scaleFactor);
                box1.setVelocityY(Math.random()*(200-100+1) + 100);
                
                let box2 = this.physics.add.sprite(Math.random()*(480-20+1)+20, 480, "monster");
                box2.setScale(scaleFactor);
                box2.setSize(25/scaleFactor, 30/scaleFactor);
                box2.setVelocityY(Math.random()*(100-200+1) - 100);

                this.boxes.push(box1, box2);

            } else {
                let box = this.physics.add.sprite(Math.random()*(480-20+1)+20, 20, "monster");
                box.setScale(scaleFactor);
                box.setSize(25/scaleFactor, 30/scaleFactor);
                box.setVelocityY(Math.random()*(200-100+1) + 100);

                this.boxes.push(box);
            }
            
            
        }

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

