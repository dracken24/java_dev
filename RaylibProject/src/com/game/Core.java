package com.game;
/* =============================================================================== */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/*               -------------------------------------------------                 */
/*                PROJET: Java Dev          PAR: Dracken24                         */
/*               -------------------------------------------------                 */
/*                CREATED: 28-2nd-2025                                             */
/*                MODIFIED BY: Dracken24                                           */
/*                LAST MODIFIED: 28-2nd-2025                                       */
/*               -------------------------------------------------                 */
/*                FILE: init.java                                                  */
/*               -------------------------------------------------                 */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/* =============================================================================== */

import static com.raylib.Raylib.initWindow;
import static com.raylib.Raylib.setTargetFPS;

import static com.raylib.Raylib.beginDrawing;
import static com.raylib.Raylib.clearBackground;
import static com.raylib.Raylib.endDrawing;
import static com.raylib.Raylib.drawText;
import static com.raylib.Raylib.getMousePosition;
import static com.raylib.Raylib.VIOLET;
import static com.raylib.Raylib.LIGHTGRAY;
import static com.raylib.Raylib.WHITE;

import com.raylib.Vector2;

import com.objects.SpriteSheet;
import com.player.Player;

public class Core
{
/***********************************************************************************/
/***                                 VARIABLES                                     */
/***********************************************************************************/

	Player		player;
	Vector2		WindowSize;
	String		title;

/***********************************************************************************/
/***                                 CONSTRUCTOR                                   */
/***********************************************************************************/

	public Core(Vector2 windowSize, String title)
	{
		WindowSize = windowSize;
		this.title = title;
		initWindow((int)WindowSize.getX(), (int)WindowSize.getY(), title);
        setTargetFPS(60);

		player = new Player();
		player.setIdle(new SpriteSheet(
			"assets/shinobi/Samurai/Idle.png",
			6,
			new Vector2(128, 128), 12
		));
		player.getIdle().setScale(1.5f);
		player.getIdle().setPosition((int)(WindowSize.getX() / 2), (int)(WindowSize.getY() / 2 ));
	}

/***********************************************************************************/
/***                                 FUNCTIONS                                     */
/***********************************************************************************/

	public void update()
	{
		beginDrawing();
			clearBackground(LIGHTGRAY);
			
			Vector2 mousePosition = getMousePosition();
            drawText("Mouse position: " + mousePosition.getX() + ", " + mousePosition.getY(), 10, 10, 20, VIOLET);
		
			player.getIdle().drawColisionBox();
			player.getIdle().updateSprite(false);
		endDrawing();
	}	
}
