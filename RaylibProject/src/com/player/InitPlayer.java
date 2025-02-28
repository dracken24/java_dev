/* =============================================================================== */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/*               -------------------------------------------------                 */
/*                PROJET: Java Dev          PAR: Dracken24                         */
/*               -------------------------------------------------                 */
/*                CREATED: 28-2nd-2025                                             */
/*                MODIFIED BY: Dracken24                                           */
/*                LAST MODIFIED: 28-2nd-2025                                       */
/*               -------------------------------------------------                 */
/*                FILE: InitPlayer.java                                            */
/*               -------------------------------------------------                 */
/* ---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~---~--- */
/* =============================================================================== */

package com.player;

import com.objects.SpriteSheet;
import com.raylib.Vector2;

import com.enums.PlayerType;

public class InitPlayer
{
	public InitPlayer(PlayerType playerType, Player player,
		Vector2 windowSize, Vector2 playerPos, Vector2 playerSize)
    {
		switch (playerType)
		{
			case SHINOBI:
                initShinobi();
				break;
			case FIGHTER:
                initFighter();
				break;
			case SAMURAI:
                initSamurai(player, windowSize, playerPos, playerSize);
				break;
		}
    }

    private void initShinobi()
    {

    }

    private void initFighter()
    {

    }

    private void initSamurai(Player player, Vector2 WindowSize,
		Vector2 playerPos, Vector2 playerSize)
    {
		// Idle
        player.setIdle(new SpriteSheet(
			"assets/shinobi/Samurai/Idle.png",
			6,
			playerSize, 12
		));
		player.getIdle().setScale(3f);
		player.getIdle().setPosition((int)playerPos.getX(), (int)playerPos.getY());

		// Run
		player.setRun(new SpriteSheet(
			"assets/shinobi/Samurai/Walk.png",
			8,
			playerSize, 6
		));
		player.getRun().setScale(3f);
		player.getRun().setPosition((int)playerPos.getX(), (int)playerPos.getY());

		player.setCurrentAction(player.getIdle());
    }
}

