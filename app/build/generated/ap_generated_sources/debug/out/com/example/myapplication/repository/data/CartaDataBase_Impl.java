package com.example.myapplication.repository.data;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class CartaDataBase_Impl extends CartaDataBase {
  private volatile CartaDAO _cartaDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `cartas` (`idCarta` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `popularidade` TEXT, `critica` TEXT, `orcamento` TEXT, `bilheteria` TEXT, `nomeFilme` TEXT, `ano` TEXT, `imagem` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"2a8e8874a29111577eb4963b06195d40\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `cartas`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsCartas = new HashMap<String, TableInfo.Column>(8);
        _columnsCartas.put("idCarta", new TableInfo.Column("idCarta", "INTEGER", true, 1));
        _columnsCartas.put("popularidade", new TableInfo.Column("popularidade", "TEXT", false, 0));
        _columnsCartas.put("critica", new TableInfo.Column("critica", "TEXT", false, 0));
        _columnsCartas.put("orcamento", new TableInfo.Column("orcamento", "TEXT", false, 0));
        _columnsCartas.put("bilheteria", new TableInfo.Column("bilheteria", "TEXT", false, 0));
        _columnsCartas.put("nomeFilme", new TableInfo.Column("nomeFilme", "TEXT", false, 0));
        _columnsCartas.put("ano", new TableInfo.Column("ano", "TEXT", false, 0));
        _columnsCartas.put("imagem", new TableInfo.Column("imagem", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCartas = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCartas = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCartas = new TableInfo("cartas", _columnsCartas, _foreignKeysCartas, _indicesCartas);
        final TableInfo _existingCartas = TableInfo.read(_db, "cartas");
        if (! _infoCartas.equals(_existingCartas)) {
          throw new IllegalStateException("Migration didn't properly handle cartas(com.example.myapplication.model.Carta).\n"
                  + " Expected:\n" + _infoCartas + "\n"
                  + " Found:\n" + _existingCartas);
        }
      }
    }, "2a8e8874a29111577eb4963b06195d40", "53c3e7cb39c708e985732d9793207050");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "cartas");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `cartas`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public CartaDAO cartaDAO() {
    if (_cartaDAO != null) {
      return _cartaDAO;
    } else {
      synchronized(this) {
        if(_cartaDAO == null) {
          _cartaDAO = new CartaDAO_Impl(this);
        }
        return _cartaDAO;
      }
    }
  }
}
