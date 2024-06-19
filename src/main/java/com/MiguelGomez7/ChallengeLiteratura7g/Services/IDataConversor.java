package com.MiguelGomez7.ChallengeLiteratura7g.Services;



public interface IDataConversor {
    <T> T convertData(String json, Class<T> clase);
}
