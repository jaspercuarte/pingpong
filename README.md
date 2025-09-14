
# 🏓pingpong1.0.1

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
## Installation & Running

### 1. Clone or Download
You can either `clone` the repository or [Download ZIP](https://github.com/yourusername/pingpong/archive/refs/heads/main.zip).

```code
git clone https://github.com/jaspercuarte/pingpong.git
cd pingpong
```

### 3. Run the Game with Batch Script
```code
.\run_pingpong.bat
```

