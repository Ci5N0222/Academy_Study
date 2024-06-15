class AmongRun extends Phaser.Scene {
    constructor() {
        super({key:"AmongRun"});
        this.frame = 0;
        this.timer = 0;
        this.score = 0;
        this.tileSpeed = 2;
        this.jumpCount = 0;
        this.items = [];
    }

    preload(){
        
        // Background preload
        this.load.image("background", "images/am-bg.png");
        
        // player charactor preload
        this.load.spritesheet("amongRun", "images/amongRun.png", {frameWidth: 237/8, frameHeight: 29});
        this.load.spritesheet("amongJump", "images/amongJump.png", {frameWidth: 316/10, frameHeight: 29});
        
        // item preload
        this.load.image("item", "images/item.png");
    }

    create(){

        // Backgrond
        this.background = this.add.tileSprite(0, 0, this.cameras.main.width, this.cameras.main.height, "background");
        this.background.setOrigin(0, 0);

        // player charactor
        this.player = this.physics.add.sprite(80, this.cameras.main.height-200, "amongRun");
        
        // player charactor size
        let playerScaleFactor = 4;
        this.player.setScale(playerScaleFactor);
        this.player.setSize(50/playerScaleFactor, 80/playerScaleFactor);

        // player charactor attribute
        this.player.setGravity(0, 1000);            // gravity
        this.player.setCollideWorldBounds(true);    // below the range
        this.player.anims.play({key:"run"});
        this.player.setData("onfloor", true);

        // player charactor "run" motion
        this.anims.create({
           key: "run",
           frames: this.anims.generateFrameNumbers("amongRun", {start:0, end:7}),
           frameRate: 11,
           repeat: -1
        });

        // player charactor "jump" motion
        this.anims.create({
           key: "jump",
           frames: this.anims.generateFrameNumbers("amongJump", {start:0, end:9}),
           frameRate: 12,
           repeat: 1
        });

        // floor
        let floor = this.add.rectangle(0, this.cameras.main.height-30, this.cameras.main.width, 5, 0x0000, 0);
        this.physics.add.existing(floor, true);
        floor.setOrigin(0, 0);

        // final boundary ( item instance delete )
        let finalBoundary = this.add.rectangle(this.cameras.main.height-20, 0, 5, this.cameras.main.height, 0x0000);
        this.physics.add.existing(finalBoundary, true);
        finalBoundary.setOrigin(100, 0);
        

        /** ============================ A and B Event ============================ **/
        
        // floor, charactor collide event
        this.physics.add.collider(floor, this.player, (floor, player) => {
            player.setData("onFloor", true);
        });

        // final boundary, item collide event
        this.physics.add.collider(finalBoundary, this.items, (final, item) => {
            // item instance delete
            item.destroy();
        });

        // player, item overlap event
        this.physics.add.overlap(this.player, this.items, (player, item) => {
            item.destroy();
            this.score += 100;
            document.querySelector("#score").innerHTML = this.score;
        });


        // keyboard event
        this.cursor = this.input.keyboard.createCursorKeys();
    }

    update(){

        this.frame++;

        // 1 second
        if(this.frame%60 === 0) {
            this.timer++;
            document.querySelector("#timer").innerHTML = this.timer;
        }

        if(this.frame%40 == 0) {
            // item 
            let item = this.physics.add.sprite(720, Math.random()*(360-110+1)+110, "item");
            
            // item size
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