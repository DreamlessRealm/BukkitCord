package top.dsbbs2.bukkitcord.api

interface IPluginDescription {
    val name: String?
    val main: String?
    val version: String?
    val author: List<String?>?
    val depends: Set<String?>?
    val softDepends: Set<String?>?
    val description: String?
    val delegate: Any?
}