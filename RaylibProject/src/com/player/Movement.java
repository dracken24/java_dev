/* =============================================================================== */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/*               -------------------------------------------------                 */
/*                PROJET: Java Dev          PAR: Dracken24                         */
/*               -------------------------------------------------                 */
/*                CREATED: 01-3rd-2025                                             */
/*                MODIFIED BY: Dracken24                                           */
/*                LAST MODIFIED: 01-3rd-2025                                       */
/*               -------------------------------------------------                 */
/*                FILE: Movement.java                                              */
/*               -------------------------------------------------                 */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/* =============================================================================== */

package com.player;

import static com.raylib.Raylib.KeyboardKey.KEY_A;
import static com.raylib.Raylib.KeyboardKey.KEY_D;
import static com.raylib.Raylib.KeyboardKey.KEY_SPACE;
import static com.raylib.Raylib.isKeyDown;
import static com.raylib.Raylib.isKeyPressed;
import static com.raylib.Raylib.isMouseButtonPressed;
    import static com.raylib.Raylib.MouseButton.MOUSE_BUTTON_LEFT;

import com.objects.SpriteSheet;
import com.enums.SpriteMovement;

public class Movement
{
/***********************************************************************************/
/***                                 VARIABLES                                     */
/***********************************************************************************/

    SpriteSheet	attack01;
    SpriteSheet	attack02;
    SpriteSheet	attack03;
    SpriteSheet	idle;
    SpriteSheet	jump;
    SpriteSheet	fall;
    SpriteSheet	run;
    SpriteSheet	walk;
    SpriteSheet	death;
    SpriteSheet	hurt;
    SpriteSheet	shild;

	SpriteSheet	currentAction;
	SpriteSheet	lastAction;

    SpriteMovement actionInProgress;

	boolean		rightSide;

    int actionCounter;

/***********************************************************************************/
/***                                 CONSTRUCTOR                                   */
/***********************************************************************************/

    public Movement()
    {
        actionInProgress = SpriteMovement.IDLE;
		rightSide = false;
        currentAction = idle;
        lastAction = null;
        actionCounter = 0;
    }

/***********************************************************************************/
/***                                 FUNCTIONS                                     */
/***********************************************************************************/

	public void update()
	{
        catchInput();
        setMovement(actionInProgress);

		if (lastAction != currentAction)
		{
			currentAction.resetCounter();
		}

		currentAction.updateSprite(false, rightSide);
	}

    void catchInput()
	{
		boolean isKeyDown = false;
        if (actionCounter > 0)
        {
            isKeyDown = true;
        }
        // System.out.println("actionCounter: " + actionCounter);
		
		if (isKeyDown(KEY_D))
		{
			rightSide = false;
            isKeyDown = true;
            if (actionCounter == 0)
            {
                this.actionInProgress = SpriteMovement.RUN;
            }
		}
		if (isKeyDown(KEY_A))
		{
			rightSide = true;
            isKeyDown = true;
            if (actionCounter == 0)
            {
                this.actionInProgress = SpriteMovement.RUN;
            }
		}
        if (isKeyPressed(KEY_SPACE))
		{
            isKeyDown = true;
            if (actionCounter == 0)
            {
                this.actionInProgress = SpriteMovement.JUMP;
                actionCounter = getJump().getAnimationTotalFrame();
            }
		}
		if (isMouseButtonPressed(MOUSE_BUTTON_LEFT))
		{
            isKeyDown = true;
            this.actionInProgress = SpriteMovement.ATTACK01;
            actionCounter = getAttack01().getAnimationTotalFrame();
		}

        // System.out.println("actionCounter: " + actionCounter);
        // System.out.println("actionInProgress: " + actionInProgress);
		if (!isKeyDown)
		{
			this.actionInProgress = SpriteMovement.IDLE;
		}
        if (actionCounter > 0)
        {
            actionCounter--;
        }
	}

/***********************************************************************************/
/***                                 GETTERS                                       */
/***********************************************************************************/

    public SpriteSheet getAttack01()
    {
        return attack01;
    }

    public SpriteSheet getAttack02()
    {
        return attack02;
    }

    public SpriteSheet getAttack03()
    {
        return attack03;
    }   

    public SpriteSheet getIdle()
    {
        return idle;
    }   

    public SpriteSheet getJump()
    {
        return jump;
    }   

    public SpriteSheet getRun()
    {
        return run;
    }      

    public SpriteSheet getWalk()
    {
        return walk;
    }   

    public SpriteSheet getDeath()
    {
        return death;
    }       

    public SpriteSheet getHurt()
    {
        return hurt;
    }   

    public SpriteSheet getShild()
    {
        return shild;
    }   

    public SpriteSheet getFall()
    {
        return fall;
    }

/***********************************************************************************/
/***                                 SETTERS                                       */
/***********************************************************************************/

    public void setAttack01(SpriteSheet attack01)
    {
        this.attack01 = attack01;
    }

    public void setAttack02(SpriteSheet attack02)
    {
        this.attack02 = attack02;
    }   

    public void setAttack03(SpriteSheet attack03)
    {
        this.attack03 = attack03;
    }   

    public void setIdle(SpriteSheet idle)
    {
        this.idle = idle;
    }

    public void setJump(SpriteSheet jump)
    {
        this.jump = jump;
    }

    public void setRun(SpriteSheet run)
    {
        this.run = run;
    }

    public void setWalk(SpriteSheet walk)
    {
        this.walk = walk;
    }

    public void setDeath(SpriteSheet death)
    {
        this.death = death;
    }

    public void setHurt(SpriteSheet hurt)
    {
        this.hurt = hurt;
    }

    public void setShild(SpriteSheet shild)
    {
        this.shild = shild;
    }

    public void setCurrentAction(SpriteSheet currentAction)
    {
        this.lastAction = this.currentAction;
        this.currentAction = currentAction;
    }

    public void setRightSide(boolean rightSide)
    {
        this.rightSide = rightSide;
    }

    public void setFall(SpriteSheet fall)
    {
        this.fall = fall;
    }

    public void setMovement(SpriteMovement movement)
    {
        switch (movement)
        {
            case IDLE:
                if (actionCounter == 0)
                {
                    setCurrentAction(idle);
                }
                break;
            case RUN:
                if (actionCounter == 0)
                {
                    setCurrentAction(run);
                }
                break;
            case JUMP:
                setCurrentAction(jump);
                break;
            case ATTACK01:
                setCurrentAction(attack01);
                break;
            case ATTACK02:
                setCurrentAction(attack02);
                {
                    setCurrentAction(attack02);
                }
                break;
            case ATTACK03:
                if (actionCounter == 0)
                {
                    setCurrentAction(attack03);
                }
                break;
            case SHILD:
                if (actionCounter == 0)
                {
                    setCurrentAction(shild);
                }
                break;
            case DEATH:
                if (actionCounter == 0)
                {
                    setCurrentAction(death);
                }
                break;
            case HURT:
                if (actionCounter == 0)
                {
                    setCurrentAction(hurt);
                }
                break;
            case WALK:
                if (actionCounter == 0)
                {
                    setCurrentAction(walk);
                }
                break;
        }
    }
}

