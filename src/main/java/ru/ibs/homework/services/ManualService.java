package ru.ibs.homework.services;

import ru.ibs.homework.entitys.Engine;
import ru.ibs.homework.entitys.Manual;

public interface ManualService {

    Manual addManual(String type, Engine engine);
}
