import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

module dk.sdu.mmmi.cbse.plugins {
    requires Common;
    exports dk.sdu.mmmi.cbse.plugins;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.plugins.SplitterPackage;
}