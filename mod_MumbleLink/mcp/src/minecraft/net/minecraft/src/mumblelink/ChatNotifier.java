/*
 mod_MumbleLink - Positional Audio Communication for Minecraft with Mumble
 Copyright 2012 zsawyer (http://sourceforge.net/users/zsawyer)

 This file is part of mod_MumbleLink
 (http://sourceforge.net/projects/modmumblelink/).

 mod_MumbleLink is free software: you can redistribute it and/or modify
 it under the terms of the GNU Lesser General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 mod_MumbleLink is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Lesser General Public License for more details.

 You should have received a copy of the GNU Lesser General Public License
 along with mod_MumbleLink.  If not, see <http://www.gnu.org/licenses/>.

 */
package net.minecraft.src.mumblelink;

import net.minecraft.client.Minecraft;
import net.minecraft.src.ModLoader;

/**
 *
 * @author zsawyer
 */
public class ChatNotifier implements UserNotifier {

    protected Minecraft game;

    public ChatNotifier() {
        game = ModLoader.getMinecraftInstance();
    }

    @Override
    public void print(String message) {
        if (canSendMessage()) {
            send(message);
        }
    }

    protected boolean canSendMessage() {
        return game != null && game.ingameGUI != null && 
                game.inGameHasFocus &&
                game.ingameGUI.func_73827_b() != null;
    }

    protected void send(String message) {
        game.ingameGUI.func_73827_b().func_73765_a(message);
    }
}