package com.example.myapplication.repository.data;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.example.myapplication.model.Carta;
import io.reactivex.Flowable;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings("unchecked")
public class CartaDAO_Impl implements CartaDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfCarta;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfCarta;

  public CartaDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCarta = new EntityInsertionAdapter<Carta>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `cartas`(`idCarta`,`popularidade`,`critica`,`orcamento`,`bilheteria`,`nomeFilme`,`ano`,`imagem`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Carta value) {
        stmt.bindLong(1, value.getId());
        if (value.getPopularidade() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPopularidade());
        }
        if (value.getCritica() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCritica());
        }
        if (value.getOrcamento() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOrcamento());
        }
        if (value.getBilheteria() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getBilheteria());
        }
        if (value.getNomeFilme() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getNomeFilme());
        }
        if (value.getAno() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getAno());
        }
        stmt.bindLong(8, value.getImagem());
      }
    };
    this.__deletionAdapterOfCarta = new EntityDeletionOrUpdateAdapter<Carta>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `cartas` WHERE `idCarta` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Carta value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public void inserirCartaBD(Carta carta) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfCarta.insert(carta);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deletarCartaBD(Carta carta) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfCarta.handle(carta);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<Carta>> todasAsCartasDB() {
    final String _sql = "SELECT * FROM cartas";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"cartas"}, new Callable<List<Carta>>() {
      @Override
      public List<Carta> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("idCarta");
          final int _cursorIndexOfPopularidade = _cursor.getColumnIndexOrThrow("popularidade");
          final int _cursorIndexOfCritica = _cursor.getColumnIndexOrThrow("critica");
          final int _cursorIndexOfOrcamento = _cursor.getColumnIndexOrThrow("orcamento");
          final int _cursorIndexOfBilheteria = _cursor.getColumnIndexOrThrow("bilheteria");
          final int _cursorIndexOfNomeFilme = _cursor.getColumnIndexOrThrow("nomeFilme");
          final int _cursorIndexOfAno = _cursor.getColumnIndexOrThrow("ano");
          final int _cursorIndexOfImagem = _cursor.getColumnIndexOrThrow("imagem");
          final List<Carta> _result = new ArrayList<Carta>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Carta _item;
            _item = new Carta();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpPopularidade;
            _tmpPopularidade = _cursor.getString(_cursorIndexOfPopularidade);
            _item.setPopularidade(_tmpPopularidade);
            final String _tmpCritica;
            _tmpCritica = _cursor.getString(_cursorIndexOfCritica);
            _item.setCritica(_tmpCritica);
            final String _tmpOrcamento;
            _tmpOrcamento = _cursor.getString(_cursorIndexOfOrcamento);
            _item.setOrcamento(_tmpOrcamento);
            final String _tmpBilheteria;
            _tmpBilheteria = _cursor.getString(_cursorIndexOfBilheteria);
            _item.setBilheteria(_tmpBilheteria);
            final String _tmpNomeFilme;
            _tmpNomeFilme = _cursor.getString(_cursorIndexOfNomeFilme);
            _item.setNomeFilme(_tmpNomeFilme);
            final String _tmpAno;
            _tmpAno = _cursor.getString(_cursorIndexOfAno);
            _item.setAno(_tmpAno);
            final int _tmpImagem;
            _tmpImagem = _cursor.getInt(_cursorIndexOfImagem);
            _item.setImagem(_tmpImagem);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
