package net.refractored.joblistings.commands

import net.refractored.joblistings.exceptions.CommandErrorException
import net.refractored.joblistings.gui.MyOrders
import net.refractored.joblistings.util.MessageUtil
import org.bukkit.entity.Player
import revxrsal.commands.annotation.Command
import revxrsal.commands.annotation.Description
import revxrsal.commands.annotation.Optional
import revxrsal.commands.bukkit.BukkitCommandActor
import revxrsal.commands.bukkit.annotation.CommandPermission
import revxrsal.commands.bukkit.player

class OwnedOrders {
    @CommandPermission("employ.view.myorders")
    @Description("View and manage orders you own")
    @Command("employ myorders")
    fun viewOrder(
        actor: BukkitCommandActor,
        @Optional player: Player? = null,
    ) {
        if (player == null) {
            actor.player.openInventory(MyOrders.getGUI(actor.player).inventory)
            return
        }
        if (!actor.player.hasPermission("employ.view.myorders.others")) {
            throw CommandErrorException(MessageUtil.getMessage("General.NoPermission"))
        }
        if (actor.isConsole) {
            throw CommandErrorException(MessageUtil.getMessage("General.PlayerOnly"))
        }
        player.openInventory(MyOrders.getGUI(player).inventory)
    }
}
