/* =============================================================================== */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/*               -------------------------------------------------                 */
/*                PROJET: Java Dev          PAR: Dracken24                         */
/*               -------------------------------------------------                 */
/*                CREATED: 28-2nd-2025                                             */
/*                MODIFIED BY: Dracken24                                           */
/*                LAST MODIFIED: 28-2nd-2025                                       */
/*               -------------------------------------------------                 */
/*                FILE: Player.java                                                */
/*               -------------------------------------------------                 */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/* =============================================================================== */

package com.player;

import com.objects.SpriteSheet;

enum Sprite
{
    ATTACK01,
    ATTACK02,
    ATTACK03,
    IDLE,
    JUMP,
    RUN,
    WALK,
    DEATH,
    HURT,
    SHILD
}

public class Player
{
/***********************************************************************************/
/***                                 VARIABLES                                     */
/***********************************************************************************/

	SpriteSheet	attack01;
    SpriteSheet	attack02;
    SpriteSheet	attack03;
    SpriteSheet	idle;
    SpriteSheet	jump;
    SpriteSheet	run;
    SpriteSheet	walk;
    SpriteSheet	death;
    SpriteSheet	hurt;
    SpriteSheet	shild;

	SpriteSheet	currentAction;

    Sprite currentSprite;

	boolean		rightSide;

/***********************************************************************************/
/***                                 CONSTRUCTOR                                   */
/***********************************************************************************/

	public Player()
	{
        currentSprite = Sprite.IDLE;
		rightSide = false;
	}

/***********************************************************************************/
/***                                 FUNCTIONS                                     */
/***********************************************************************************/

	public void update()
	{
		currentAction.updateSprite(false, rightSide);
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
		this.currentAction = currentAction;
	}

	public void setRightSide(boolean rightSide)
	{
		this.rightSide = rightSide;
	}
}