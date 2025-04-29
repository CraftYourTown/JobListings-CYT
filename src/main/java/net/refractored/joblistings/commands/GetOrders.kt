package net.refractored.joblistings.commands

import net.refractored.joblistings.exceptions.CommandErrorException
import net.refractored.joblistings.gui.AllOrders
import net.refractored.joblistings.util.MessageUtil
import org.bukkit.entity.Player
import revxrsal.commands.annotation.DefaultFor
import revxrsal.commands.annotation.Description
import revxrsal.commands.annotation.Optional
import revxrsal.commands.annotation.Subcommand
import revxrsal.commands.bukkit.BukkitCommandActor
import revxrsal.commands.bukkit.annotation.CommandPermission
import revxrsal.commands.bukkit.player

class GetOrders {
    @CommandPermission("employ.view.myorders")
    @Description("View all pending orders")
    @DefaultFor("employ")
    @Subcommand("orders")
    fun getOrders(
        actor: BukkitCommandActor,
    ) {
        if (actor.isConsole) {
            throw CommandErrorException(MessageUtil.getMessage("General.PlayerOnly"))
        }
        actor.player.openInventory(AllOrders.getGUI().inventory)
    }
}
