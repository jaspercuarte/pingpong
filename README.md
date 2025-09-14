
# 🏓pingpong1.0.2

GUI-based PingPong game written in Java (Swing).  

Features both ***single-player*** (with difficulty levels) and ***two-player*** modes.  

The game includes a special ***Critical Hit System*** for dynamic gameplay.


## Features

### Game Modes
**1 Player Mode**
    - Bot Difficulty levels: `Easy`, `Medium`, `Hard`

**2 Player Mode**
    - Play locally with a friend on the same keyboard

---
### Critical Hit Mechanic
Each paddle hit has a ***5% chance*** to trigger a ***Critical Hit***

On Critical Hit:
  - `Ball speed temporarily increases`
  - `Speed reverts back after that specific hit`

On the **first paddle hit**:
  - `Ball speed increases by +8`

Afterwards:
  - `Increment by 1 every hit by paddle`
  - `Only increments > 1 again if a Critical Hit occurs`

---
### Sound Effect and Music
  - `Paddle hits and scoring effects`
  - `Menu with play/exit options`

---
## Recent Changes `1.0.1 -> 1.0.2`

### Default Attributes
  - `critChance = .05`
  - `critPowerBonus (critSpeedBoost) = 0`
  - `width = 25`
  - `height = 100`
  - `paddleSpeed = 10`

--- 
### Paddle Variation
  - `Default` (default critChance, default critPowerBonus, default width, default height, default paddleSpeed) 
  - `Lucky` (30% critChance, default critPowerBonus, default width, default height, default paddleSpeed)
  - `Power` (3% critChance, increment12 critPowerBonus, default width, default height, default paddleSpeed)
  - `Swift` (default critChance, default critPowerBonus, default*3/4 width, default*3/4 height, 19 paddleSpeed)
  - `Tank` (default critChance, default critPowerBonus, default*3/2 width, default*3/2 height, 4 paddleSpeed)

---
## Installation & Running

### 1. Clone or Download
You can either `clone` the repository or [Download ZIP](https://github.com/yourusername/pingpong/archive/refs/heads/main.zip).

```code
git clone https://github.com/jaspercuarte/pingpong.git
cd pingpong
```

### 2. Run the Game with Batch Script (CMD or Windows Powershell)
Check the batch script for the process (if want to be done manually)

```code
.\run_pingpong.bat
```

