package com.Collocation.Stage.Service.interfaces;

import com.Collocation.Stage.entities.Piece;

import java.util.List;

public interface PieceInteface {
    List<Piece> getAllPieces();

    Piece getPieceById(Integer id);

    Piece savePiece(Piece piece);

    Piece updatePiece(Integer id, Piece updatedPiece);

    List<Piece> getAvailablePieces() ;
    void deletePiece(Integer id);
    Piece updatePieces(Integer id, Piece updatedPiece);
}
