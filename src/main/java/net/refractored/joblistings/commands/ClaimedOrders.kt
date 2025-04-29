package net.refractored.joblistings.commands

import net.refractored.joblistings.exceptions.CommandErrorException
import net.refractored.joblistings.gui.ClaimedOrders
import net.refractored.joblistings.util.MessageUtil
import org.bukkit.entity.Player
import revxrsal.commands.annotation.Command
import revxrsal.commands.annotation.Description
import revxrsal.commands.annotation.Optional
import revxrsal.commands.bukkit.BukkitCommandActor
import revxrsal.commands.bukkit.annotation.CommandPermission
import revxrsal.commands.bukkit.player

class ClaimedOrders {
    @CommandPermission("employ.view.claimed")
    @Description("View the orders you claimed")
    @Command("employ claimed")
    fun getOrders(
        actor: BukkitCommandActor,
        @Optional player: Player? = null,
    ) {
        if (player == null) {
            actor.player.openInventory(ClaimedOrders.getGUI(actor.player).inventory)
            return
        }
        if (!actor.player.hasPermission("employ.view.claimed.other")) {
            throw CommandErrorException(MessageUtil.getMessage("General.NoPermission"))
        }
        if (actor.isConsole) {
            throw CommandErrorException(MessageUtil.getMessage("General.PlayerOnly"))
        }
        player.openInventory(ClaimedOrders.getGUI(player).inventory)
    }
}
