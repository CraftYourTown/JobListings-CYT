package net.refractored.joblistings.commands

import net.refractored.joblistings.config.Presets
import net.refractored.joblistings.exceptions.CommandErrorException
import net.refractored.joblistings.util.MessageReplacement
import net.refractored.joblistings.util.MessageUtil
import revxrsal.commands.annotation.AutoComplete
import revxrsal.commands.annotation.Command
import revxrsal.commands.annotation.Description
import revxrsal.commands.bukkit.BukkitCommandActor
import revxrsal.commands.bukkit.annotation.CommandPermission

class RemovePreset {
    @CommandPermission("employ.admin.remove.preset")
    @Description("Removes a preset from the config and memory.")
    @Command("employ preset remove")
    @AutoComplete("@presets")
    fun removePreset(
        actor: BukkitCommandActor,
        presetName: String,
    ) {
        if (actor.isConsole) {
            throw CommandErrorException(
                MessageUtil.getMessage("General.IsNotPlayer"),
            )
        }
        if (Presets.getPresets()[presetName] == null) {
            throw CommandErrorException(
                MessageUtil.getMessage("RemovePreset.PresetDoesNotExist"),
            )
        }
        Presets.removePreset(presetName)
        actor.reply(
            MessageUtil.getMessage(
                "RemovePreset.RemovedPreset",
                listOf(MessageReplacement(presetName)),
            ),
        )
    }
}
