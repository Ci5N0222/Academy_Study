class GameOver extends Phaser.Scene {
    constructor(){
        super({key: "GameOver"});
    }

    preload(){

    }

    create(){
        this.add.text(this.cameras.main.width/2, this.cameras.main.height/2-30, "Game Over", {
            fontSize: "40px",
            fill: "#FF0000"
        }).setOrigin(0.5);

        let restartBtn = this.add.text(this.cameras.main.width/2, this.cameras.main.height/2 + 60, "Restart", {
            fontSize: "25px",
            fill: "#FF0000"
        }).setOrigin(0.5).setInteractive();

        restartBtn.on("pointerover", () => {
            restartBtn.setBackgroundColor("#0000FF");
            this.game.canvas.style.cursor = "pointer";
        });

        restartBtn.on("pointerout", () => {
            restartBtn.setBackgroundColor("#FF0000");
            this.game.canvas.style.cursor = "pointer";
        });

        restartBtn.on("pointerdown", () => {
            this.scene.start("Exam02");
        });
    }

    update(){

    }

}