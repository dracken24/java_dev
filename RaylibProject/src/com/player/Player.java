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
import com.raylib.Vector2;
import static com.raylib.Raylib.drawRectangleRec;
import static com.raylib.Raylib.DARKGRAY;
import static com.raylib.Raylib.WHITE;

import com.raylib.Rectangle;

public class Player
{
/***********************************************************************************/
/***                                 VARIABLES                                     */
/***********************************************************************************/

	Movement	movement;
	Vector2		position;
	Vector2		size;
	Rectangle	colisionBox;
	int			scale;

/***********************************************************************************/
/***                                 CONSTRUCTOR                                   */
/***********************************************************************************/

	public Player(Vector2 position, Vector2 size, Rectangle colisionBox, int scale)
	{
		movement = new Movement();
		this.position = position;
		this.size = size;
		this.scale = scale;
		this.colisionBox = colisionBox;
	}

/***********************************************************************************/
/***                                 FUNCTIONS                                     */
/***********************************************************************************/

	public void update()
	{
		// drawSize();
		drawColisionBox();
		movement.update();
	}

	void drawColisionBox()
	{
		Rectangle colBox = new Rectangle(colisionBox.getX(), colisionBox.getY(), colisionBox.getWidth() * scale, colisionBox.getHeight() * scale);
		drawRectangleRec(colBox, DARKGRAY);
	}

	void drawSize()
	{
		drawRectangleRec(new Rectangle(position.getX() - (size.getX() / 2 * scale), position.getY() - (size.getY() / 2 * scale), size.getX() * scale, size.getY() * scale), WHITE);
	}

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