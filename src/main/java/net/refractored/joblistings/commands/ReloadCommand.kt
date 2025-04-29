package net.refractored.joblistings.commands

import net.refractored.joblistings.JobListings
import net.refractored.joblistings.util.MessageUtil
import revxrsal.commands.annotation.Command
import revxrsal.commands.annotation.Description
import revxrsal.commands.bukkit.BukkitCommandActor
import revxrsal.commands.bukkit.annotation.CommandPermission

class ReloadCommand {
    @CommandPermission("employ.admin.reload")
    @Description("Reloads plugin configuration")
    @Command("employ reload")
    fun reload(actor: BukkitCommandActor) {
        JobListings.instance.reload()
        actor.reply(MessageUtil.getMessage("Reload.Reloaded"))
    }
}
