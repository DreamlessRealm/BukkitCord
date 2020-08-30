package top.dsbbs2.bukkitcord.utils.command

import top.dsbbs2.bukkitcord.api.ICommandExecutor
import top.dsbbs2.bukkitcord.api.ITabCompleter

interface CommandWithCompleter : ICommandExecutor, ITabCompleter 