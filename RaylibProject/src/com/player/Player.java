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

import com.enums.SpriteMovement;

public class Player
{
/***********************************************************************************/
/***                                 VARIABLES                                     */
/***********************************************************************************/

	Movement	movement;

/***********************************************************************************/
/***                                 CONSTRUCTOR                                   */
/***********************************************************************************/

	public Player()
	{
		movement = new Movement();
	}

/***********************************************************************************/
/***                                 FUNCTIONS                                     */
/***********************************************************************************/

	public void update()
	{
		movement.update();
		// catchInput();
	}

	// void catchInput()
	// {
	// 	movement.catchInput();
	// }

/***********************************************************************************/
/***                                 GETTERS                                       */
/***********************************************************************************/



/***********************************************************************************/
/***                                 SETTERS                                       */
/***********************************************************************************/

	public void setMovementSide(boolean rightSide)
	{
		movement.setRightSide(rightSide);
	}

	public void setMovement(SpriteMovement movement)
	{
		this.movement.setMovement(movement);
	}

}